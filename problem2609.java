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

class problem2609{
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
        String input=scan.nextLine();
        int sol=findTheLongestBalancedSubstring(input);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int findTheLongestBalancedSubstring(String s) {
        int max=0;
        for (int i = 0; i < s.length(); ) {
            int zero=0;
            int one=0;  
            while(i<s.length() && s.charAt(i)=='0'){
                zero++;
                i++;
            }
            while(i<s.length() && s.charAt(i)=='1' && zero>one){
                one++;
                i++;
                max=Math.max(max,2*one);
            }
            while(i<s.length() && s.charAt(i)=='1'){
                i++;
            }
        }
        return max;
    }
}  