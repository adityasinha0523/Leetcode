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

class problem520{
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
        boolean sol=detectCapitalUse("FlaG");
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static boolean detectCapitalUse(String word) {
        int counter=0;
        int upper=0;
        for (int i = 0; i < word.length(); i++) {
            char c=word.charAt(i);
            if(i==0){
                if(Character.isUpperCase(c)){
                    upper++;
                }
            }
            if(Character.isUpperCase(c)){
                counter++;
            }
        }
        if(upper==1){
            if(counter==word.length()||counter==1){
                return true;
            }else{
                return false;
            }
            
        }else if(upper==0 && counter==0){
            return true;
        }
        else{
            return false;
        }
    }
}  
