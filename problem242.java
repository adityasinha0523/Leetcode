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

class problem242{
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

        String s=scan.nextLine();
        String t=scan.nextLine();
        boolean sol=isAnagram(s, t);
        System.out.println(sol);
        scan.close();
    }  
    public static boolean isAnagram2(String s, String t) {
        int[] firstArr=new int[26];
        int[] secondArr=new int[26];
        for (int i = 0; i < s.length(); i++) {
            firstArr[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            secondArr[t.charAt(i)-'a']++;
        }
        for (int i = 0; i < secondArr.length; i++) {
            if(firstArr[i]!=secondArr[i]){
                return false;
            }
        }
        return true;
    }


    public static boolean isAnagram(String s, String t) {
        boolean solution=true;
        int[] alphabet=new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i)-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if(alphabet[i]!=0){
                return false;
            }
        }
        return solution;
    }
}  
