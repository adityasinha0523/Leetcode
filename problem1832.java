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

class problem1832{
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
        boolean sol=checkIfPangram("thequckbrownfoxjumpsoverthelazydog");
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static boolean checkIfPangram(String sentence) {
        int[] count=new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            Character c=sentence.charAt(i);
            count[c-'a']++;
        }
        for (int i = 0; i < count.length; i++) {
            if(count[i]==0){
                return false;
            }
        }
        return true;
    }

    public static boolean checkIfPangram2(String sentence) {
        int[] count=new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            int value=sentence.charAt(i)-'a';
            count[value]++;
        }
        for (int i = 0; i < 26; i++) {
            if(count[i]==0){
                return false;
            }
        }
        return true;
    }
}  