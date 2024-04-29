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

class problem2000{
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
        Scanner scan = new Scanner(System.in);
        //For reading string from input file
        //String myLine = scan.nextLine();
        //scan.nextLine();
        //To take int array as input
        
        /*int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/
        
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static String reversePrefix(String word, char ch) {

        StringBuilder sb=new StringBuilder();
        boolean found=false;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i)!=ch){
                sb.append(word.charAt(i));
            }else{
                if(found){
                    sb.append(word.charAt(i));
                }else{
                    sb.append(word.charAt(i));
                    sb.reverse();
                }
            }
        }
        return sb.toString();
        /*int last=-1;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i)==ch){
                last=i;
                break;
            }
        }
        if(last==-1){
            return word;
        }
        int first=0;
        char[] ch1=word.toCharArray();
        while(first<last){
            char temp=ch1[first];
            ch1[first]=ch1[last];
            ch1[last]=temp;
            first++;
            last--;
        }
        String sol=String.valueOf(ch1);
        return sol;*/
    }
}  