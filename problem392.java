import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

import javax.print.FlavorException;

import java.lang.*;

class problem392{
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
        
        //1D Array
        /*int[] nums=new int[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/

        //Taking 2D Array as input
        /*int[][] nums=new int[3][3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                nums[i][j]=scan.nextInt();
            }
        }*/

        //Taking String as input.
        //String s=scan.nextLine();

        boolean sol=isSubsequence("leetcode", "yyyylyyyyeyyyyyeyyyytyyycyyyoyyydyyyeyyy");
        //Printing 1D Array.
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }
    
    /*public static boolean isSubsequence2(String s, String t) {
        int firstStart=0;
        int secondStart=0;
        while(firstStart<s.length() && secondStart<t.length()){
            if(s.charAt(firstStart)==t.charAt(secondStart)){
                firstStart++;
                secondStart++;
            }else{
                secondStart++;
            }
        }
        if(firstStart==s.length()){
            return true;
        }else{
            return false;
        }
    }*/

    public static boolean isSubsequence2(String s, String t) {
        int firstStart=0;
        int secondStart=0;
        while(firstStart<s.length() && secondStart<t.length()){
            if(s.charAt(firstStart)==t.charAt(secondStart)){
                firstStart++;
                secondStart++;
            }else{
                secondStart++;
            }
        }
        if(firstStart==s.length()){
            return true;
        }
        return false;
    }

    public static boolean isSubsequence(String s, String t) {
        int[] freq1=new int[26];
        int[] freq2=new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq1[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            freq2[t.charAt(i)-'a']++;
        }
        for (int i = 0; i < freq1.length; i++) {
            if(freq1[i]>freq2[i]){
                return false;
            }
        }
        int prevIndex=-1;
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            boolean found=false;
            for (int j = prevIndex+1; j < t.length(); j++) {
                if(t.charAt(j)==c){
                    found=true;
                    if(j>=prevIndex){
                        prevIndex=j;
                        break;
                    }else{
                        return false;
                    }
                    
                }
            }
            if(found==false){
                return false;
            }
        }
        return true;
    }
}  
