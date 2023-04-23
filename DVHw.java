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

class DVHw{
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
        String[] list=new String[247];
        for (int i = 0; i < list.length; i++) {
            list[i]=scan.nextLine();
        }

        for (int i = 0; i < list.length; i++) {
            StringBuilder sb=new StringBuilder();
            String s=list[i];
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j)!=','){
                    sb.append(s.charAt(j));
                }
            }
            System.out.println(sb.toString());
        }
        scan.close();
    }  

}  