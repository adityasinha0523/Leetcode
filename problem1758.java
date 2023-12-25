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

class problwm1758{
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
        
        //1D Array
        /*int[] nums=new int[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/

        //Taking 2D Array as input
        /*int[][] nums=new int[3][3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                nums[i][j]=scan.nextInt();
            }
        }*/

        //Taking String as input.
        //String s=scan.nextLine();


        //Printing 1D Array.
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        /*for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.println( sol[i][j]);
            }
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static int minOperations(String s) {
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(i%2==0){
                sb1.append('0');
            }else{
                sb2.append('1');
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if(i%2==0){
                sb1.append('1');
            }else{
                sb2.append('0');
            }
        }
        //int solution=0;
        int first=0;
        int second=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='0' && sb1.charAt(i)=='1'){
                first++;
            }if(s.charAt(i)=='1' &&sb1.charAt(i)=='0'){
                first++;
            }if(s.charAt(i)=='0' && sb2.charAt(i)=='1'){
                second++;
            }if(s.charAt(i)=='0' && sb2.charAt(i)=='1'){
                second++;
            }
        }
        
        return Math.min(first,second);
    }
}  