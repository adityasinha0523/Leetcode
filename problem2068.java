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

class problem2068{
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
        String s1="cccddabba";
        String s2="babababab";
        boolean sol=checkAlmostEquivalent(s1, s2);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static boolean checkAlmostEquivalent(String word1, String word2) {
        int[] count1=new int[26];
        int[] count2=new int[26];
        for (int i = 0; i < word1.length(); i++) {
            count1[word1.charAt(i)-'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            count2[word2.charAt(i)-'a']++;
        }
        for (int i = 0; i < count2.length; i++) {
            if(Math.abs(count1[i]-count2[i])>3){
                return false;
            }
        }
        return true;
    }
}  
