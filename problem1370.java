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

class problem1370{
public static void main(String args[]) throws IOException{  
    if (System.getProperty("ONLINE_JUDGE") == null) {
        // Redirecting the I/O to external files
        // as ONLINE_JUDGE constant is not defined which
        // means
        // the code is not running on an online judge
        PrintStream ps= new PrintStream(new File("output.txt"));
        InputStream is= new FileInputStream("input.txt");
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
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static String sortString(String s) {
        int[] count=new int[26];
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }
        while(true){
            boolean found=false;
            for (int i = 0; i < count.length; i++) {
                if(count[i]!=0){
                    found=true;
                    sb.append((char)(i+96));
                }
            }
            if(found==false){
                return sb.toString();
            }else{
                for (int i = count.length-1; i >=0 ; i--) {
                    if(count[i]!=0){
                        found=true;
                        sb.append((char)(i+96));
                    }
                }
            }
        }
    }
}  
