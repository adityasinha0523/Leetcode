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

class problem36{
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
    
    public static boolean isValidSudoku(char[][] board) {
        //Case 1:Column check
        for (int i = 0; i < board.length; i++) {
            Set<Integer> set=new HashSet<>(); 
            for (int j = 0; j < board[0].length; j++) {
                char c=board[i][j];
                if(c=='.'){
                    continue;
                }else{
                    int value=c-'0';
                    if(set.contains(value)){
                        return false;
                    }else{
                        set.add(value);
                    }
                }
            }
        }
        //Case 2:Row Traversal
        for (int i = 0; i < board[0].length; i++) {
            Set<Integer> set=new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                char c=board[j][i];
                if(c=='.'){
                    continue;
                }else{
                    int value=c-'0';
                    if(set.contains(value)){
                        return false;
                    }else{
                        set.add(value);
                    }
                }
            }
        }

        //Case 3:3*3 Case
        for (int i = 0; i < board.length; i=i+3) {
            int rowEnd=i+2;
            for (int j = 0; j < board[0].length; j=j+3) {
                int colEnd=j+2;
                boolean val=traversal(board,i,rowEnd,j,colEnd);
                if(val==false){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean traversal(char[][] board,int rowStart,int rowEnd,int colStart,int colEnd) {
        Set<Integer> set=new HashSet<>();
        for (int i = rowStart; i <=rowEnd; i++) {
            for (int j = colStart; j <=colEnd; j++) {
                char c=board[j][i];
                if(c=='.'){
                    continue;
                }else{
                    int value=c-'0';
                    if(set.contains(value)){
                        return false;
                    }else{
                        set.add(value);
                    }
                }
            }
        }
        return true;
    }
}  
