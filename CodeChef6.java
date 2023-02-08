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

class CodeChef6{
    public static void main(String args[]) throws IOException{  
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
		while (T-- > 0) {
            int length=in.nextInt();
            int[] arr=new int[length];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=in.nextInt();
            }
            int max=0;
            int counter=0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]>max){
                    max=arr[i];
                    counter=1;
                }else if(arr[i]==max){
                    counter++;
                }
            }
            if(counter%2==0){
                System.out.println("Zenyk");
            }else{
                System.out.println("Marichka");
            }
		}
        in.close();
    }
}  
