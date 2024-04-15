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

class problem268{
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

        int[] nums=new int[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        int sol=missingNumber(nums);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    /*public static int missingNumber(int[] nums) {
        int actualXor=0;
        int n=nums.length;
        for (int i = 0; i < nums.length; i++) {
            actualXor=nums[i]^actualXor;
        }
        int expectedXor=0;
        for (int i = 0; i <=n; i++) {
            expectedXor=expectedXor^i;
        }
        return expectedXor^actualXor;
    }*/

    public static int missingNumber(int[] nums) {
        /*int actualXor=0;
        int expectedXor=0;
        for (int i = 0; i < nums.length; i++) {
            actualXor=actualXor^nums[i];
        }
        for (int i = 0; i <=nums.length; i++) {
            expectedXor=expectedXor^i;
        }
        return expectedXor^actualXor;*/
        int actualXor=0;
        int expectedXor=0;
        for (int i = 0; i < nums.length; i++) {
            actualXor=actualXor^nums[i];
        }
        for (int i = 0; i <=nums.length; i++) {
            expectedXor=expectedXor^i;
        }
        return expectedXor^actualXor;
    }

    public static int missingNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i!=nums[i]){
                return i;
            }
        }
        return nums.length;
    } 
    
    public static int missingNumber3(int[] nums) {
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        int result=nums.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>mid){
                result=mid;
                right=mid-1;
            }else if(nums[mid]<mid){
                //result=mid;
                left=mid+1;
            }else{
                //result++;
                left=mid+1;
            }
        }
        return result;
    }
}  
