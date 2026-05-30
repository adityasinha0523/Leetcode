import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TimestampStreamProcessor {
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm:ss");
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm");
    private static final Pattern DATA_PATTERN = Pattern.compile("(\\d{4}-\\d{2}-\\d{2} \\d{1,2}:\\d{2}:\\d{2}) (\\d+\\.\\d+)");
    
    // Map to store timestamp minute -> list of values
    private final Map<String, List<Double>> minuteToValues = new HashMap<>();
    // Set to track which minutes have been processed
    private final Set<String> processedMinutes = new HashSet<>();
    // Store the most recent timestamp seen
    private LocalDateTime latestTimestamp = null;
    
    public void processRecord(String record) {
        // Parse input record
        Matcher matcher = DATA_PATTERN.matcher(record);
        
        if (!matcher.matches()) {
            // Skip noisy/invalid records
            System.out.println("Dropping noisy record: " + record);
            return;
        }
        
        String timestampStr = matcher.group(1);
        String valueStr = matcher.group(2);
        
        try {
            LocalDateTime timestamp = LocalDateTime.parse(timestampStr, INPUT_FORMATTER);
            double value = Double.parseDouble(valueStr);
            
            // Group by minute (truncate seconds)
            String minuteKey = timestamp.truncatedTo(ChronoUnit.MINUTES).format(OUTPUT_FORMATTER);
            
            // Add value to corresponding minute
            minuteToValues.computeIfAbsent(minuteKey, k -> new ArrayList<>()).add(value);
            
            // Update latest timestamp seen
            if (latestTimestamp == null || timestamp.isAfter(latestTimestamp)) {
                latestTimestamp = timestamp;
            }
            
            // Process minutes that are ready (at least 5 minutes old)
            processReadyMinutes();
            
        } catch (Exception e) {
            // Skip any record that fails to parse
            System.out.println("Dropping record due to parsing error: " + record);
        }
    }
    
    private void processReadyMinutes() {
        if (latestTimestamp == null) return;
        
        // Determine the cutoff time (5 minutes before the latest timestamp)
        LocalDateTime cutoffTime = latestTimestamp.minusMinutes(5);
        
        // Process all minutes that are before the cutoff
        for (String minuteKey : new ArrayList<>(minuteToValues.keySet())) {
            if (processedMinutes.contains(minuteKey)) {
                continue; // Skip already processed minutes
            }
            
            LocalDateTime minuteTime = LocalDateTime.parse(minuteKey, OUTPUT_FORMATTER);
            
            if (minuteTime.isBefore(cutoffTime) || minuteTime.isEqual(cutoffTime)) {
                List<Double> values = minuteToValues.get(minuteKey);
                double average = values.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
                
                // Print result
                System.out.print ("Avg value is ");
                System.out.printf("%s %.10f%n", minuteKey, average);
                // Mark as processed
                processedMinutes.add(minuteKey);
            }
        }
    }
    
    // Method to force processing any remaining minutes when the stream ends
    public void finalizeProcessing() {
        // Process all remaining unprocessed minutes
        for (String minuteKey : new ArrayList<>(minuteToValues.keySet())) {
            if (!processedMinutes.contains(minuteKey)) {
                List<Double> values = minuteToValues.get(minuteKey);
                double average = values.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
                
                // Print result
                System.out.print ("Final Avg value is ");
                System.out.printf("%s %.10f%n", minuteKey, average);
            }
        }
    }
    
    public static void main(String[] args) {
        TimestampStreamProcessor processor = new TimestampStreamProcessor();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter timestamp and value records (Ctrl+D to end):");
        System.out.println("Format: yyyy-MM-dd H:mm:ss value");
        
        // Skip header line if present
        if (scanner.hasNextLine()) {
            String firstLine = scanner.nextLine();
            if (firstLine.contains("timestamp") && firstLine.contains("unified_anomaly")) {
                // This is a header, skip it
            } else {
                // Not a header, process as a record
                processor.processRecord(firstLine);
            }
        }
        
        // Process input stream
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) continue;
            processor.processRecord(line);
        }
        
        // Process any remaining minutes when the stream ends
        processor.finalizeProcessing();
        
        scanner.close();
    }
}