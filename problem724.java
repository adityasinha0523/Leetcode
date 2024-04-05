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

class problem724{
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
        //For reading integer from input file
        //int a=scan.nextInt();
        //String temp1="leetcodeisacommunityforcoders";
        //int temp2=4;
        /*int [] input=new int[4];
        for (int i = 0; i < input.length; i++) {
            input[i]=scan.nextInt();
        }*/

        
        //scan.nextLine();
        //To take array as input
        int[] num=new int[6];
        for (int i = 0; i < num.length; i++) {
            num[i]=scan.nextInt();
        }
        int sol=pivotIndex2(num);
        
        System.out.println(sol);
        scan.close();
    }  

    public static int pivotIndex2(int[] nums) {
        int leftSum=0;
        int totalSum=0;
        for (int i = 0; i < nums.length; i++) {
            totalSum+=nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int val=totalSum-nums[i];
            if(val==leftSum){
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
        
    }
    public static int pivotIndex(int[] nums) {
        int sum=0;
        int leftSum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if(leftSum==sum-leftSum-nums[i]){
                return i;
            }else{
                leftSum+=nums[i];
            }
        }
        return -1;
    }
}  