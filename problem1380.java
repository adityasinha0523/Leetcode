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

class problem1380{
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

    public static List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> solution=new ArrayList<>();
        List<Integer> minRow=new ArrayList<>();
        List<Integer> maxCol=new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int min=Integer.MAX_VALUE;
            for (int j = 0; j < matrix[0].length; j++) {
                min=Math.min(min, matrix[i][j]);
            }
            minRow.add(min);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            int max=Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                max=Math.max(max, matrix[j][i]);
            }
            if(minRow.contains(max)){
                solution.add(max);
            }
        }
        return solution;
    }
}  