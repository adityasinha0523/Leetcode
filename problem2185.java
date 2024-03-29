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

class problem2185{
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
        String[] words=new String[4];
        for (int i = 0; i < words.length; i++) {
            words[i]=scan.nextLine();
        }
        String pref=scan.nextLine();
        int sol=prefixCount(words,pref);
        System.out.println(sol);
        scan.close();
    }  

    public static int prefixCount(String[] words, String pref) {
        int solution=0;
        for (int i = 0; i < words.length; i++) {
            String str=words[i];
            boolean notEqual=false;
            if(pref.length()>str.length()){
                continue;
            }
            for (int j = 0; j < pref.length(); j++) {
                if(pref.charAt(j)!=str.charAt(j)){
                    notEqual=true;
                    break;
                }
            }
            if(notEqual==false){
                solution++;
            }
        }
        return solution;
    }
}  