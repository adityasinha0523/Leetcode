import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class problemHashMap{
    public static void main(String args[]) throws IOException{  
        if (System.getProperty("ONLINE_JUDGE") == null) {
            // Redirecting the I/O to external files
 
            // as ONLINE_JUDGE constant is not defined which
            // means
 
            // the code is not running on an online judge
 
            PrintStream ps
                = new PrintStream(new File("output.txt"));
            InputStream is
                = new FileInputStream("input.txt");
 
            System.setIn(is);
            System.setOut(ps);
        }
        Scanner scan = new Scanner(System.in);
        /*
         * 1.To Initialize hashmap use below command.
         * Example:
         */
        Map<Integer,Integer> hMap=new HashMap<>();

        /*
         * 2.To Insert value in HashMap use below command.
         * Example:
         */
        hMap.put(1, 2);

        /*
         * 3.To insert value when it is already not present use putIfAbsent().
         * It will only insert in hashmap if key is not present in hashmap.
         * JDK Doc states that
         *  If the specified key is not already associated with a value
         *  (or is mapped to null) associates it with the given value 
         * and returns null, else returns the current value. 
         * Example:
         */
        hMap.putIfAbsent(2, 3);

        /*
         * 4.To add value with default value use getOrDefault() function below command.
         * Example:
         */
        hMap.put(5, hMap.getOrDefault(10, 0)+1);

        /*
         * 5. To print key and value in hashmap.
         */
        for (Map.Entry<Integer,Integer> hEntry : hMap.entrySet()) {
            int key=hEntry.getKey();
            int value=hEntry.getValue();
            System.out.println(key);
            System.out.println(value);
        }

        /*
         * 6.To insert value in hashmap in sorted order we can use TreeMap instead
         * of Hashmap.Example
         */
        Map<Integer,Integer> hMap2=new TreeMap<>();
        hMap2.put(10, 1);
        hMap2.put(1, 5);
        //Will put the value in order 1,10 internally in TreeMap.
        scan.close();
    }  

    
}  