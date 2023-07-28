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
import java.util.*;

class problem1662{
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
        String[] string1=new String[2];
        for (int i = 0; i < string1.length; i++) {
            string1[i]=scan.nextLine();
        }
        String[] string2=new String[2];
        for (int i = 0; i < string2.length; i++) {
            string2[i]=scan.nextLine();
        }
        boolean answer=arrayStringsAreEqual(string1,string2);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(answer);
        scan.close();
    }  

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < word1.length; i++) {
            char[] c=word1[i].toCharArray();
            for (int j = 0; j < c.length; j++) {
                sb.append(c[j]);
            }
        }
        StringBuilder sb1=new StringBuilder();
        for (int i = 0; i < word2.length; i++) {
            char[] c=word2[i].toCharArray();
            for (int j = 0; j < c.length; j++) {
                sb1.append(c[j]);
            }
        }
        if(sb.toString().equals(sb1.toString())){
            return true;
        }
        return false;
    }
}  