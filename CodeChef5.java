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

class CodeChef5{
    public static void main(String args[]) throws IOException{  
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
		while (T-- > 0) {
            int length=in.nextInt();
            String s=in.next();
            int[] count=new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i)-'a']++;
            }
            int min=-1;
            for (int i = 0; i < count.length; i++) {
                if(count[i]>=2){
                    min=2;
                    break;
                }
            }
            if(min==-1){
                System.out.println("-1");
            }else{
                System.out.println(length-min);
            }
		}
        in.close();
    }
}  
