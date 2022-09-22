// You don't need to add/edit anything to the below solution. 
// Click on the SUBMIT button to solve your first problem on CodeChef.

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;


// Remember that the class name should be "Main" and should be "public".
public class Starter57DQues3 {
	public static void main(String[] args) {
		// System.in and System.out are input and output streams, respectively.
		InputStream inputStream = System.in;

		InputReader in = new InputReader(inputStream);

		// Read the number of test casese.		
		int T = in.nextInt();
		while (T-- > 0) {
			// Read the numbers a and b.
			int a = in.nextInt();
            int[] inputArray=new int[a];
            for (int i = 0; i < inputArray.length; i++) {
                inputArray[i]=in.nextInt();
            }
            int count=0;
            int zeroCount=0;
            boolean zero=false;
            for (int i = 0; i < inputArray.length; i++) {
                if(inputArray[i]<0){
                    count++;
                }
                if(inputArray[i]==zeroCount){
                    zero=true;
                    zeroCount++;
                }
            }
            if(count%2==0){
                System.out.println(0);
            }else{
                if(zero==true){
                    if(zeroCount%2==0){
                        System.out.println(0);;
                    }else{
                        System.out.println(1);
                    }
                }else{
                    System.out.println(1);
                }
                
            }
		}
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
				    tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
				    throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
