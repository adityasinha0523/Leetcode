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

class OverlapSquare{
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
    public static int func(int[][]input){
        int[][] convert=new int[input.length][4];
        int solution=0;
        for (int i = 0; i < input.length; i++) {
            int x=input[i][0];
            int y=input[i][1];
            int x1=x+1;
            int x2=x-1;
            int y1=y+1;
            int y2=y-1;
            convert[i][0]=x1;
            convert[i][1]=y1;
            convert[i][2]=x2;
            convert[i][3]=y2;
        }
        for (int i = 0; i < input.length; i++) {
            int[] first=input[i];
            for (int j = 0; j < input[0].length; j++) {
                int[] second=input[j];
                boolean answer=isRectangleOverlap(first, second);
                if(answer==true){
                    solution++;
                }
            }
        }
        return solution;
    }
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return(!(rec1[2]<=rec2[0]||rec1[3]<=rec2[1]||rec2[2]<=rec1[0]||rec2[3]<=rec1[1]));
    }
}  

