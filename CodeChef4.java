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

class CodeChef4{
    public static void main(String args[]) throws IOException{  
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
		while (T-- > 0) {
			// Read the numbers a and b.
			int a = in.nextInt();
            int[] arr=new int[3];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=in.nextInt();
            }
            int key=in.nextInt();
            Arrays.sort(arr);
			if((arr[2]+arr[1])>=key){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
		}
        in.close();
    }  


}  
