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

class problem2373{
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
        int[][] grid=new int[4][4];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j]=scan.nextInt();
            }
        }
        int[][]sol=largestLocal(grid);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.println(sol[i][j]);
            }
        }
        //System.out.println(sol);
        scan.close();
    }  

    public static int[][] largestLocal(int[][] grid) {
        /*int[][] solution=new int[grid.length-2][grid.length-2];
        for (int i = 0; i < grid.length-2; i++) {
            for (int j = 0; j < grid.length-2; j++) {
                int max=-1;
                for (int k = 0; k < 3; k++) {
                    for (int k2 = 0; k2 <3; k2++) {
                        max=Math.max(max, grid[i+k][j+k2]);
                    }
                }
                solution[i][j]=max;
            }
        }
        return solution;*/

        int[][] solution=new int[grid.length-2][grid.length-2];
        for (int i = 0; i < grid.length-2; i++) {
            for (int j = 0; j < grid[0].length-2; j++) {
                int sol=findMax(i,j,grid);
                solution[i][j]=sol;
            }
        }
        return solution;
    }

    public static int findMax(int i,int j,int[][] grid){
        int maxValue=-1;
        for (int k = i; k < i+2; k++) {
            for (int k2 = j; k2 < j+2; k2++) {
                maxValue=Math.max(maxValue, grid[k][k2]);
            }
        }
        return maxValue;
    }
}  