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

class problemString{
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

        
        /*
         * 1.To convert character array to string use String.valueOf(char[] obj).
         * Example:
         */
        String s="hello";
        char[] c=s.toCharArray();
        String string=String.valueOf(c);
        
        /*
         * 2.To convert String to character array use s.toCharArray();
         * Example:
         */

        String s1="hello";
        char[] charString=s.toCharArray();
        scan.close();

        /*
         * 3.To compare two character whether they are equal or not.
         */
        char a='a';
        char b='b';
        int value=Character.compare(a, b);//Should return 0 if they are equal.
        if(value==0){
            System.out.println("Both character are equal");
        }
    }  

}  