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
import java.lang.*;

class problem2575{
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
        
        /*int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/
        String word="998244353";
        int[] sol=divisibilityArray(word, 3);
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] div = new int[n];
        long remainder = 0;
        for (int i = 0; i < n; i++) {
            int digit = word.charAt(i) - '0';
            remainder = (remainder * 10 + digit) % m;
            if (remainder == 0) {
                div[i] = 1;
            }
        }
        return div;
    }
    public static int[] divisibilityArray1(String word, int m) {
        int[] sol=new int[word.length()];
        long remainder=0l;
        for (int i = 0; i < word.length(); i++) {
            int digit=Character.getNumericValue(word.charAt(i));
            remainder=(remainder*10+digit)%m;
            if(remainder==0){
                sol[i]=1;
            }
        }
        return sol;
    }

}  