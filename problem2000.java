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

class problem2000{
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
        
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static String reversePrefix(String word, char ch) {
        int locate=0;
        char[] c=word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i)==ch){
                locate=i;
                break;
            }
        }
        char[] sol=new char[word.length()];
        for (int i = 0; i < locate; i++) {
            sol[i]=c[locate-i];
        }
        for (int i = locate+1; i < word.length(); i++) {
            sol[i]=c[i];
        }
        return String.valueOf(word);
    }
}  