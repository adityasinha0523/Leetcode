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

class problem1921{
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
        int[] nums1=new int[5];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i]=scan.nextInt();
        }

        int[] nums2=new int[5];
        for (int i = 0; i < nums2.length; i++) {
            nums2[i]=scan.nextInt();
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

        int sol=eliminateMaximum(nums1, nums2);
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

    public static int eliminateMaximum(int[] dist, int[] speed) {
        double[] time=new double[dist.length];
        for (int i = 0; i < dist.length; i++) {
            time[i]=(double)dist[i]/speed[i];
        }
        Arrays.sort(time);
        int solution=0;
        double count=0;
        if(time.length>=1 &&time[1]==0){
            return 1;
        }
        for (int i = 0; i < time.length; i++) {
            if(time[i]-solution>0){
                solution+=1;
            }else{
                break;
            }
        }
        return solution;
    }
}  