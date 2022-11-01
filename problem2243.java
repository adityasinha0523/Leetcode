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

class problem2243{
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
        String sol= digitSum("11111222223", 3);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static String digitSum(String s, int k) {
        while(true){
            StringBuilder sb=new StringBuilder();
            int t=0;
            for (int i = 0; i < s.length(); i++) {
                int kCounter=0;
                int sum=0;
                if(t<s.length()){
                    while(t<s.length()&&kCounter<k){
                        sum=sum+Character.getNumericValue( s.charAt(t));
                        kCounter++;
                        t++;
                    }
                    sb.append(String.valueOf(sum));
                }
            }
            s=sb.toString();
            if(s.length()<=k){
                return s;
            }
        }
    }
}  
