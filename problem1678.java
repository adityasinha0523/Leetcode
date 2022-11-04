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

class problem1678{
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
        String sol=interpret("(al)G(al)()()G");
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static String interpret(String command) {
        StringBuilder sb=new StringBuilder();
        int start=0;
        while(start<command.length()){
            if(command.charAt(start)=='('&& command.charAt(start+1)==')'){
                sb.append("o");
                start=start+2;
                continue;
            }
            if(command.charAt(start)=='('&& command.charAt(start+1)=='a'){
                sb.append("al");
                start=start+3;
                continue;
            }
            if(command.charAt(start)=='G'){
                sb.append("G");
                start=start+1;
                continue;
            }
            start=start+1;
        }
        return sb.toString();
    }
}  