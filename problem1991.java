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
import java.util.*;
import java.lang.*;

class problem1991{
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
        //For reading string from input file
        //String myLine = scan.nextLine();
        //scan.nextLine();
        //To take int array as input
        
        int[] nums=new int[2];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        int sol=findMiddleIndex(nums);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int findMiddleIndex(int[] nums) {
        int prefix=0;
        int suffix=0;
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            suffix=sum-prefix;
            prefix+=nums[i];
            if(suffix==prefix){
                return i;
            }
        }
        return -1;
    }
}  