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

class CodeChef3{
    public static void main(String args[]) throws IOException{  
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
		while (T-- > 0) {
			// Read the numbers a and b.
			int a = in.nextInt();
			if(a<80){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
		}
        in.close();
    }  


}  
