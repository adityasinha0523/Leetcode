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

class problem917{
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
        String sol=reverseOnlyLetters("a-bC-dEf-ghIj");
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static String reverseOnlyLetters2(String s) {
        int first=0;
        int last=s.length()-1;
        StringBuilder sb=new StringBuilder();
        while(last!=0){
            if(Character.isAlphabetic(s.charAt(first))){
                if(Character.isAlphabetic(s.charAt(last))){
                    sb.append(s.charAt(last));
                }
                last--;
            }else{
                if(!Character.isAlphabetic(s.charAt(last))){
                    last--;
                }
                sb.append(s.charAt(first));
            }
            first++;
            //last--;
        }
        return sb.toString();
    }

    public static String reverseOnlyLetters(String s) {
        StringBuilder sb=new StringBuilder();
        StringBuilder initialString=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isAlphabetic(s.charAt(i))){
                initialString.append(s.charAt(i));
            }
        }
        String intString=initialString.toString();
        int last=intString.length()-1;
        for (int i = 0; i < s.length(); i++) {
            if(Character.isAlphabetic(s.charAt(i))){
                sb.append(intString.charAt(last--));
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}  