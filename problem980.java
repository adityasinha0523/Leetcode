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

class problem980{
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

    static int answer=0;
    
    public static int uniquePathsII(int[][] grid) {
        int i=grid.length;
        int j=grid[0].length;
        int totalZero=1;
        for (int j2 = 0; j2 < grid.length; j2++) {
            for (int k = 0; k < grid[0].length; k++) {
                if(grid[i][j]==0){
                    totalZero++;
                }
            }
        }
        for (int k = 0; k < grid.length; k++) {
            for (int k2 = 0; k2 < grid.length; k2++) {
                if(grid[i][j]==1){
                    backtrack(grid,i,j,0,totalZero);
                }
            }
        }
        return answer;
    }

    public void backtrack(int[][] grid,int i,int j,int count,int totalZero){
        if(grid[i][j]==2 && count==totalZero){
            answer++;
        }
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==-1){
            return;
        }
        int temp=grid[i][j];
        grid[i][j]=-1;
        backtrack(grid, i-1, j, count+1, totalZero);
        backtrack(grid, i+1, j, count+1, totalZero);
        backtrack(grid, i, j+1, count+1, totalZero);
        backtrack(grid, i, j-1, count+1, totalZero);
        if(temp==0||temp==1){
            grid[i][j]=0;
        }
    }













    public int uniquePathsIII(int[][] grid) {
        int a=0;
        int b=0;
        int count=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){
                    a=i;
                    b=j;
                }else if(grid[i][j]==0){
                    count++;
                }
            }
        }
        return search(grid,a, b, count);
    }

    public static int search(int[][] board,int i,int j,int index){
        

        if(i>=board.length ||i<0 ||j>=board[0].length ||j<0||board[i][j]==-1){
            return 0;
        }
        if(board[i][j]==2){
            return index==-1?1:0;
        }
        board[i][j]=-1;
        index--;
        int count=search(board, i+1, j, index)+
        search(board, i-1, j, index)+
        search(board,  i, j+1, index)+
        search(board,  i, j-1, index);

        board[i][j]=0;
        index++;
        return count;
    }
}  
