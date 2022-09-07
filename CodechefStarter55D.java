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

class CodechefStarter55D{
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
		while (T-- > 0) {
			// Read the numbers a and b.
			int a = in.nextInt();
			LinkedHashSet<Integer> firstArr=new LinkedHashSet<>();
			for (int i=0;i<a ;i++ ){
			    firstArr.add(in.nextInt());
			}
			int b=in.nextInt();
			int[] secondArr=new int[b] ;
		    for (int i=0;i<b ;i++ ){
		        secondArr[i]=in.nextInt();
		    }
		    for(int i:secondArr){
                if(firstArr.contains(i)){
                    firstArr.remove(i);
                }
		    }
            ArrayList<Integer> answer=new ArrayList<>(firstArr);
            for (int i = 0; i < answer.size(); i++) {
                System.out.print(answer.get(i));
                System.out.print(" ");
            }
		}
        in.close();
    }  


}  
