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

class problem2670{
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
    public static int[] distinctDifferenceArray(int[] nums) {
        int[] sol=new int[nums.length];
        Map<Integer,Integer> prefix=new HashMap<>();
        Map<Integer,Integer> suffix=new HashMap<>();
        for (int i : nums) {
            suffix.put(i, suffix.getOrDefault(i, 0)+1);
        }
        int k=0;
        for (int i = 0; i < nums.length; i++) {
            int val=nums[i];
            prefix.put(val, prefix.getOrDefault(val, 0)+1);
            suffix.put(val, suffix.getOrDefault(val, 0)-1);
            if(suffix.get(val)==0){
                suffix.remove(val);
            }
            sol[k++]=prefix.size()-suffix.size();
        }
        return sol;
    }
}  