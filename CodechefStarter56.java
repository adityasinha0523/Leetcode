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
import java.util.Scanner;
import java.util.List;
import java.util.*;
import java.lang.*;

class CodechefStarter56{
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
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] arr=new int[3];
		while (T-- > 0) {
			// Read the numbers a and b.
			arr[0] = in.nextInt();
			arr[1] = in.nextInt();
			arr[2] = in.nextInt();
			int sum=0;
            Arrays.sort(arr);
			if(arr[0]!=0){
                arr[0]--;
			    sum+=1;
			}if(arr[1]!=0){
                arr[1]--;
			    sum+=1;
			}if(arr[2]!=0){
                arr[2]--;
			    sum+=1;
            Arrays.sort(arr);
			}if(arr[0]!=0 && arr[1]!=0){
                arr[0]--;
                arr[1]--;
			    sum+=1;
			}if(arr[1]!=0 && arr[2]!=0){
                arr[1]--;
                arr[2]--;
			    sum+=1;
			}if(arr[0]!=0 && arr[2]!=0){
			    sum+=1;
			}
			System.out.println(sum);
		}
        in.close();
    }  

}  