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
import java.util.Scanner;
import java.util.List;
import java.util.*;
import java.lang.*;

class problemArray{
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
        //For reading integer from input file
        //int a=scan.nextInt();
        //String temp1="leetcodeisacommunityforcoders";
        //int temp2=4;
        /*int [] input=new int[4];
        for (int i = 0; i < input.length; i++) {
            input[i]=scan.nextInt();
        }*/

        
        //scan.nextLine();
        //To take array as input
        int[] num=new int[4];
        for (int i = 0; i < num.length; i++) {
            num[i]=scan.nextInt();
        }
        /*
         * 1.To copy Array from one Array 
         * to another new array 
         * use one line command.
         */
        int[] A=Arrays.copyOf(num, num.length);


        /*
         * 2.To sort the existing Array in ascending order
         */
        Arrays.sort(A);

        /*
         * 3.Sorting 2D Array with second index in descending order
         */

        int[][] array2D=new int[3][3];
        array2D[0][0]=1;
        array2D[0][1]=2;
        array2D[0][2]=3;
        array2D[1][0]=4;
        array2D[1][1]=5;
        array2D[1][2]=6;
        array2D[2][0]=7;
        array2D[2][1]=8;
        array2D[2][2]=9;
        Arrays.sort(array2D, (a,b)->b[1]-a[1]);
        
        scan.close();
    }  

}  