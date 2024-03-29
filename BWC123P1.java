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

class BWC123P1{
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
        
        //1D Array
        int[] nums=new int[6];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }

        //Taking 2D Array as input
        /*int[][] nums=new int[3][3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                nums[i][j]=scan.nextInt();
            }
        }*/

        //Taking String as input.
        //String s=scan.nextLine();

        int sol=maxOperations(nums);
        //Printing 1D Array.
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        /*for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.println( sol[i][j]);
            }
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int maxOperations(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int defaultScore = nums[0] + nums[1];
        int operations = 0;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int startScore = nums[i] + nums[i + 1];
            i=i+2;
            if (startScore == defaultScore) {
                operations++;
            }else{
                break;
            }
            
            if(i<j){    
                int endScore = nums[j] + nums[j - 1];
                j=j-2;
                if (endScore == defaultScore) {
                    operations++;
                }else{
                    break;
                } 
            }
            else{
                break;
            }
            if(i<j){
                int mixScore = nums[i] + nums[j];
                i=i+1;
                j=j-1;
                if (mixScore == defaultScore) {
                    operations++;
                }else{
                    break;
                }
            }
            else{
                break;
            }
        }
        return operations;
    }
}  