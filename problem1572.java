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

class problem1572{
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
        
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static int diagonalSum(int[][] mat) {
        int leftToRight=0;
        int rightToLeft=0;
        int n=0;
        int m=mat.length;
        //int sum=m-1;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(i==j){
                    leftToRight+=mat[i][j];
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            rightToLeft+=mat[m-1-i][i];
        }
        if(mat.length%2!=0){
            rightToLeft-=mat[m/2][m/2];
        }
        return leftToRight+rightToLeft;
    }
}  
