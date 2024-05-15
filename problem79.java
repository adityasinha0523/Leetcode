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

import javax.crypto.SealedObject;
import javax.swing.border.Border;

import java.lang.*;

class problem79{
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
    //static boolean found;
    public static  boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(backtrack(board,i,j,0,word)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean backtrack(char[][] board,int i,int j,int index,String word){
        if(index==word.length()){
            return true;
        }
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]=='$'){
            return false;
        }
        if(board[i][j]!=word.charAt(index)){
            return false;
        }
        char temp=board[i][j];
        board[i][j]='$';
        if(backtrack(board, i+1, j, index+1, word)||backtrack(board,i-1,j,index+1,word)
        ||backtrack(board, i, j+1, index+1, word)||backtrack(board, i, j-1, index, word)){
            return true;
        }
        board[i][j]=temp;
        return false;
    }
}  

