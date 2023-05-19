import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.lang.*;

class problem2671{
    public static void main(String args[]) throws IOException{  
        if (System.getProperty("ONLINE_JUDGE") == null) {
            // Redirecting the I/O to external files
            // as ONLINE_JUDGE constant is not defined which
            // means
            // the code is not running on an online judge
            PrintStream ps= new PrintStream(new File("output.txt"));
            InputStream is= new FileInputStream("input.txt");
            System.setIn(is);
            System.setOut(ps);
        }
        Scanner scan = new Scanner(System.in);
        //For reading string from input file
        //String myLine = scan.nextLine();
        //scan.nextLine();
        //To take int array as input
        
        /*int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/
        
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    private Map<Integer,Integer> map;
    private Map<Integer,Integer> freq;
    public void FrequencyTracker() {
        map = new HashMap<>();
        freq = new HashMap<>();
    }

    public void add(int number) {
        int count = 0;
        if(map.containsKey(number)) count = map.get(number);

        //we have previous count so decrease it if its not 0
        if(count != 0){
            if(freq.get(count) == 1) freq.remove(count);
            else freq.put(count, freq.get(count) - 1);
        }
        map.put(number, map.getOrDefault(number, 0) + 1);

        if(count == 0){
            freq.put(1, freq.getOrDefault(1, 0) + 1);
        }else{
            //We incremented current number so we take count + 1
            freq.put(count + 1, freq.getOrDefault(count + 1, 0) + 1);
        }
    }

    public void deleteOne(int number) {
       // if the map doesn't contain the number then just return.
       if(!map.containsKey(number)) return;

       //if the number present only one time then just remove it.
       if(map.get(number) == 1){
           map.remove(number);

           //update its corresponding freq map.
           if(freq.get(1) == 1) freq.remove(1);
           else freq.put(1, freq.get(1) - 1);
       }else{
        //if the number present more than one time then just decrease it count.
           int count = map.get(number);
        //we remove 1 from current count in the freq.
           if(freq.get(count) == 1) freq.remove(count);
           else freq.put(count, freq.get(count) - 1);
           map.put(number, map.get(number) - 1);

           count = map.get(number);
        //we add 1 to the decreased count in the freq.
           freq.put(count, freq.getOrDefault(count, 0) + 1);
       }
    }

    public boolean hasFrequency(int frequency) {

        return freq.containsKey(frequency);
    }
}  