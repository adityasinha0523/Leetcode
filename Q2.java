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
import java.util.Map.Entry;

import javax.swing.text.AbstractDocument.LeafElement;

import java.lang.*;

class Q2{
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
        
        String input="abcdef";
        //Output -->afbecd
        //Input -->abcde
        //Output -->aebdc
        String sol=solution(input);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static String solution(String s){
        StringBuilder sb=new StringBuilder();
        int first=0;
        int last=s.length()-1;
        while(first<last){
            sb.append(s.charAt(first));
            sb.append(s.charAt(last));
            first++;
            last--;
        }if(s.length()%2!=0){
            sb.append(s.charAt(first));
        }
        return sb.toString();
    }
}  