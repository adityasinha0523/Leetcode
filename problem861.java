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

class problem861{
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
        /*int[] nums=new int[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/

        //Taking 2D Array as input
        /*int[][] nums=new int[3][3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                nums[i][j]=scan.nextInt();
            }
        }*/

        //Taking String as input.
        //String s=scan.nextLine();

        //String xValue=Integer.toBinaryString(5);
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
        //System.out.println(sol);
        scan.close();
    }  

    public static int matrixScore(int[][] grid) {
        int ans=0;
        for (int i = 0; i < grid.length; i++) {
            if(grid[i][0]==0){
                grid=row(grid,i);
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            if(columnfind(grid,i)<=grid.length/2){
                grid=column(grid,i);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            String s="";
            for (int j = 0; j < grid[0].length; j++) {
                s=s+Integer.toString(a[i][j]);
            }
            ans+=Integer.valueOf(s, 2);
        }
        return ans;
    }

    public static int[][] row(int[][]grid,int index){
        for (int i = 0; i < grid[index].length; i++) {
            if(grid[index][i]==1){
                grid[index][i]=0;
            }else{
                grid[index][i]=1;
            }
        }
        return grid;
    }

    public static int[][] column(int[][]grid,int index){
        for (int i = 0; i < grid.length; i++) {
            if(grid[i][index]==1){
                grid[i][index]=0;
            }else{
                grid[i][index]=1;
            }
        }
        return grid;
    }

    public static int columnfind(int[][] grid,int index){
        int count=0;
        for (int i = 0; i < grid.length; i++) {
            if(grid[i][index]==1){
                count++;
            }
        }
        return count;
    }
}  