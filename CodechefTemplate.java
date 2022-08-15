// Java Program that is been setup in Sublime Text
// for Competitive Coding

// Importing input output classes
import java.io.*;
import java.lang.reflect.Array;
// Importing Scanner class from java.util package
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;



// Replace with Main Class during submission
public class CodechefTemplate  {
	// Main driver method
	public static void main(String[] args){

		// Setting up the input stream
		// You can use buffered reader too
		Scanner read = new Scanner(System.in);

		// If You Are Running Your Code
		// in Sublime Text then set The
		// System Out to output.txt and
		// Input Stream to input.txt
		// otherwise leave it as standard
		// ones for ONLINE JUDGE
		
			// Try block to check for exceptions
			/*try {
				// Sets the Output Stream
				// to output.txt
				System.setOut(new PrintStream(
					new FileOutputStream("output.txt")));

				// Change the input stream
				// to input.txt
				read = new Scanner(new File("input.txt"));
			}

			// Catch block to handle the exceptions
			catch (Exception e) {
			}*/
		

		// Your Code Start Here

		// Read input
		//String str= read.nextLine();
		//int power=	read.nextInt();
		//int module=read.nextInt();
		//int n=read.nextInt();
		//int array[]=new int[n];
		//int hashValue=read.nextInt();
		/*for (int i = 0; i < n; i++) {
			array[i]=read.nextInt();
		}*/

		int t=read.nextInt();
		while(t-- >0){
			int first=read.nextInt();
			String val=read.next();
			int solution=0;
			Map<Character,Integer> hMap=new HashMap<>();
			for (int i = 0; i < val.length(); i++) {
				if(hMap.containsKey(val.charAt(i))){
					if(hMap.get(val.charAt(i))==i-1){
						hMap.remove(val.charAt(i));
					}
					else{
						hMap.put(val.charAt(i),i);
						solution++;
					}
				}else{
					hMap.put(val.charAt(i),i);
					solution++;
				}
			}

			System.out.println(solution);
			
		}		
	}
}	