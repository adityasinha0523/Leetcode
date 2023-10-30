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

class problem54{
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
        //System.out.println(sol);
        scan.close();
    }  

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> sol=new ArrayList<>();
        int rows=matrix.length;
        int column=matrix[0].length;
        int left=0;
        int up=0;
        int down=rows-1;
        int right=column-1;
        while(sol.size()<rows*column){
            for (int col = left; col <=right; col++) {
                sol.add(matrix[up][col]);
            }
            for (int row = up+1; row <=down; row++) {
                sol.add(matrix[row][right]);
            }
            if(up!=down){
                for (int col = right-1; col >=left; col--) {
                    sol.add(matrix[down][col]);
                }
            }
            if(left!=right){
                for (int row = down-1; row >up; row--) {
                    sol.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            up++;
            down--;
        }
        return sol;
    }
}  