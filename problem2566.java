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

class problem2566{
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
        int n=scan.nextInt();
        int sol=minMaxDifference(n);
        //Printing 1D Array.
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int minMaxDifference(int num) {
        char[] x=String.valueOf(num).toCharArray();
        char[] y=String.valueOf(num).toCharArray();
        char p=x[0];
        char q=x[0];
        int k=0;
        for (int i = 0; i < x.length; i++) {
            if(x[i]!='9'){
                p=x[i];
                break;
            }
        }
        for (int i = 0; i < y.length; i++) {
            if(x[i]==p){
                x[i]='9';
            }
        }
        for (int i = 0; i < y.length; i++) {
            if(y[i]==q){
                y[i]='0';
            }
        }
        return Integer.parseInt(String.valueOf(x)) -Integer.parseInt(String.valueOf(y));
    }
}  