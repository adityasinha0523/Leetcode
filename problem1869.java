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
import java.util.Scanner;
import java.util.List;
import java.util.*;
import java.lang.*;

class problem1869{
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

        /*int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/
        String s="01";
        boolean sol=checkZeroOnes(s);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static boolean checkZeroOnes(String s) {
        int oneCount=0;
        int zeroCount=0;
        int maxOneCount=0;
        int maxZeroCount=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='1'){
                maxZeroCount=Math.max(maxZeroCount, zeroCount);
                zeroCount=0;
                oneCount++;
            }else{
                maxOneCount=Math.max(maxOneCount, oneCount);
                oneCount=0;
                zeroCount++;
            }
        }
        maxZeroCount=Math.max(maxZeroCount, zeroCount);
        maxOneCount=Math.max(maxOneCount, oneCount);
        if(maxOneCount>maxZeroCount){
            return true;
        }else{
            return false;
        }
    }
}  