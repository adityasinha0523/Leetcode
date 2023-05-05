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

class problem944{
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
        String[] s=new String[2];
        for (int i = 0; i < s.length; i++) {
            s[i]=scan.nextLine();
        }
        System.out.println("Input value is");
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
        System.out.println("End");
        int sol=minDeletionSize(s);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  


    public static int minDeletionSize(String[] strs) {
        int solution=0;
        int k=0,l=0;
        char[][] arrStr=new char[strs[0].length()][strs.length];
        for (int i = 0; i < strs.length; i++) {
            String s=strs[i];
            k=0;
            for (int j = 0; j < s.length(); j++) {
                arrStr[k++][l]=s.charAt(j);
            }
            l++;
        }
        
        for (int i = 0; i < arrStr.length; i++) {
            int value=-1;
            for (int j = 0; j < arrStr[0].length; j++) {
                char s=arrStr[i][j];
            
                if((s-'a')<value){
                    solution++;
                    break;
                }else{
                    value=s-'a';
                }
            }
        }
        return solution;
    }
}  