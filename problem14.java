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

class problem14{
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
        String[] strs=new String[3];
        for (int i = 0; i < strs.length; i++) {
            strs[i]=scan.nextLine();
        }
        String sol=longestCommonPrefix(strs);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }
    
    public static String longestCommonPrefix2(String[] strs) {
        String first=strs[0];
        String prefix=first;
        for (int i = 1; i < strs.length; i++) {
            String val=strs[i];
            int firstStart=0;
            int secondStart=0;
            StringBuilder sb=new StringBuilder();
            while(firstStart<val.length() && secondStart<prefix.length()){
                if(prefix.charAt(secondStart)!=val.charAt(firstStart)){
                    break;
                }else{
                    sb.append(prefix.charAt(secondStart));
                    secondStart++;
                    firstStart++;
                }
            }
            prefix=sb.toString();
        }
        return prefix;
    }

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }
}  
