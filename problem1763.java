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

class problem1763{
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
        String sol=longestNiceSubstring("YazaAay");
        /*int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static String longestNiceSubstring(String s) {
        if(s.length()<2){
            return "";
        }
        char[] arr=s.toCharArray();
        Set<Character> set=new HashSet<>();
        for(char c:arr){
            set.add(c);
        }
        for (int i = 0; i < s.length(); i++) {
            char c=arr[i];
            if(set.contains(Character.toUpperCase(c)) &&set.contains(Character.toLowerCase(c))){
                continue;
            }
            String prev=longestNiceSubstring(s.substring(0, i));
            String next=longestNiceSubstring(s.substring(i+1));
            return prev.length()>next.length()?prev:next;
        }
        return s;
    }

}  