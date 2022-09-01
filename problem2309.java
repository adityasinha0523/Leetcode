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

class problem2309{
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
        Integer a=10;
        String k=a.toString();
        String s="abCdec";
        String sol=greatestLetter(s);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static String greatestLetter(String s) {
        int[] lowercase=new int[26];
        int[] uppercase=new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c>='a' && c<='z'){
                lowercase[c-'a']++;
            }else{
                uppercase[c-'A']++;
            }
        }
        String solution="";
        for (int i = 0; i < uppercase.length; i++) {
            if(lowercase[i]>0 && uppercase[i]>0){
                String s1=Character.toString((char)(i +'A'));
                return s1;
            }
        }
        return solution;
    }
}  