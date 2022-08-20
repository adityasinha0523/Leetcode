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

class problem2129{
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

        
        String title=scan.nextLine();
        String sol=capitalizeTitle(title);
        
        System.out.println(sol);
        scan.close();
    }  

    public static String capitalizeTitle(String title) {
        StringBuilder sb=new StringBuilder();
        String[] stringArr=title.split(" ");
        for (int i = 0; i < stringArr.length; i++) {
            if(stringArr[i].length()<3){
                for (int j = 0; j < stringArr[i].length(); j++) {
                    Character p=Character.toLowerCase(stringArr[i].charAt(j));
                    sb.append(p);
                }
                if(i!=stringArr.length-1){
                    sb.append(" ");
                }
            }else{
                int j=0;
                Character c=Character.toUpperCase(stringArr[i].charAt(j));
                sb.append(c);
                for (j = 1; j < stringArr[i].length(); j++) {
                    Character k=Character.toLowerCase(stringArr[i].charAt(j));
                    sb.append(k);
                }
                if(i!=stringArr.length-1){
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}  