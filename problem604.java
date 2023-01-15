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

class problem604{
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
    static StringBuilder sb=new StringBuilder();
    static int counter=0;
    public static void StringIterator(String compressedString) {
        /*for (int i = 1; i < compressedString.length(); i=i+2) {
            int value=Character.getNumericValue(compressedString.charAt(i));
            char char1=compressedString.charAt(i-1);
            while(value!=0){
                sb.append(char1);
                value--;
            }
        }*/
        int first=0;
        while(first<compressedString.length()){
            int sum=0;
            char c=' ';
            if(Character.isAlphabetic(compressedString.charAt(first))){
                c=compressedString.charAt(first);
                first++;
            }else{
                sum=Character.getNumericValue(compressedString.charAt(first));
                first++;
                while(first<compressedString.length() &&Character.isDigit(compressedString.charAt(first))){
                    sum=sum*10+Character.getNumericValue(compressedString.charAt(first));
                }
            }
            while(sum!=0){
                sb.append(c);
                sum--;
            }
        }
    }
    
    public static char next() {
        if(counter<sb.length()){
            //counter++;
            char c=sb.toString().charAt(counter);
            counter++;
            return c;
        }
        return ' ';
    }
    
    public static boolean hasNext() {
        if(counter<sb.length()){
            return true;
        }else{
            return false;
        }
    }
}  
