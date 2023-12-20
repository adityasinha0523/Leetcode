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

class problem2110Contest{
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
        int[] nums=new int[16];
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

        long sol=getDescentPeriods(nums);
        //Printing 1D Array.
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static long getDescentPeriods(int[] prices) {
        if(prices.length==1){
            return 1;
        }
        long solution=1;
        //int i=1;
        int start=0;
        //int end=0;
        for (int end = 1; end < prices.length; end++) {
            if(prices[end]==prices[end-1]-1){
                solution+=end-start+1;
            }else{
                start=end;
                solution+=end-start+1;
            }
        }
        /*while(i<prices.length){
            if(prices[i-1]-prices[i]==1){
                int count=1;
                while(i<prices.length && prices[i-1]-prices[i]==1){
                    count++;
                    i++;
                }
                solution+=(count*(count-1))/2;
                solution+=count;
            }else{
                solution++;
                i++;
            }
        }*/
        return solution;
    }
}  