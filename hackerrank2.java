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

class hackerrank2{
    public static void main(String args[]) throws IOException{  
        Scanner in = new Scanner(System.in);
        String inputString = in.next();
        int counter=0;
        char[] sb=new char[inputString.length()];
        for (int i = 0; i < inputString.length(); i++) {
            sb[i]=inputString.charAt(i);
        }
        while(true){
            boolean found=false;
            for (int i = 0; i < sb.length-1; i++) {
                if(sb[i]=='a' && sb[i+1]=='b'){
                    counter++;
                    found=true;
                    char temp=sb[i];
                    sb[i]=sb[i+1];
                    sb[i+1]=temp;
                }
            }
            if(found==false){
                break;
            }
        }
        System.out.println("Output arr");
        for (int i = 0; i < sb.length; i++) {
            System.out.println(sb[i]);
        }
        System.out.println(counter);
        in.close();
    }
}  
