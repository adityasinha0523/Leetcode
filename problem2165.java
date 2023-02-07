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

class problem2165{
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

    public static long smallestNumber(long num) {
        if(num == 0){
            return 0;
        }
        num  = num < 0 ? num * -1 : num;
        char[] c=String.valueOf(num).toCharArray();
        Arrays.sort(c);
        String s1="";
        if(num>0){
        int index=0;
        for (int i = 0; i < c.length; i++) {
            if(c[i]!='0'){
                index=i;
                break;
            }
        }
        char temp=c[index];
        c[index]='0';
        c[0]=temp;
        s1=new String(c);
        }
        else{
            s1=new String(c);
            StringBuilder sb=new StringBuilder(s1);
            //sb.append("-");
            s1="-".concat(sb.reverse().toString());
        }
        return Long.valueOf(s1);
    }
}  