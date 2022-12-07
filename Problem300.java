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

class Problem300{
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
        
        int[] nums=new int[7];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        int sol=lengthOfLIS(nums);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int lengthOfLIS(int[] nums) {
        int solution=0;
        int[] output=new int[nums.length];
        output[0]=1;
        for (int i = 1; i < nums.length; i++) {
            output[i]=1;
            for (int j = i-1; j>=0; j--) {
                if(nums[j]>=nums[i]){
                    continue;
                }else{
                    int maxSolution=output[j]+1;
                    if(maxSolution>output[i]){
                        output[i]=maxSolution;
                    }
                }
            }
        }
        for (int i = 0; i < output.length; i++) {
            solution=Math.max(solution, output[i]);
        }
        return solution;
    }
}  