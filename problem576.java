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

class problem576{
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
    int M,N;
    static int MOD=(int) (1e9+7);
    //List<List<Integer>> directions={{0,1}};
    public static int solve(int startRow,int startColumn,int maxMove,int m,int n){
        if(startRow<0||startColumn<0||startRow>=m||startColumn>=n){
            return 1;
        }
        if(maxMove<=0){
            return 0;
        }
        int result=0;

        result+=solve(startRow-1, startColumn, maxMove-1,m,n)%MOD + solve(startRow+1, startColumn, maxMove-1,m,n)%MOD +
            solve(startRow, startColumn-1, maxMove-1,m,n)%MOD + solve(startRow, startColumn+1, maxMove-1,m,n)%MOD;
        return result;

    }
    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        //return solve(startRow,startColumn,maxMove,m,n);
        int dp[][][] = new int[m][n][maxMove + 1];

        for(int [][] i : dp) 
            for(int s1[] : i) {
                Arrays.fill(s1, -1);
            }
        
        return solve(m, n, maxMove, startRow, startColumn, dp);
    }
}  
