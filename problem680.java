import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.lang.*;

class problem680{
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
    
    public static boolean validPalindrome(String s) {
        int start=0;
        int end=s.length()-1;
        while(start<end){
            if(s.charAt(start)==s.charAt(end)){
                start++;
                end--;
            }else{
                if(isValid(s,++start,end) ||isValid(s,start,--end)){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isValid(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean validPalindrome(String s) {
        int first=0;
        int last=s.length()-1;
        int counter=0;
        while(first<last){
            if(s.charAt(first)!=s.charAt(last)){
                return checkPal(first+1,last,s)||checkPal(first,last-1,s);
            }
            first++;
            last--;
        }
        return true;
    }
    public static boolean checkPal(int first,int last,String s){
        while(first<last){
        if(s.charAt(first++)!=s.charAt(last--)){
            return false;
        }
        }
        return true;
    }
}  