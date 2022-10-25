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

class problem2119{
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
        boolean sol=isSameAfterReversals(0);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static boolean isSameAfterReversals(int num) {
        //boolean solution=true;
        int rev1=0;
        int rev2=0;
        int initial=num;
        while(num>0){
            int temp=num%10;
            rev1=rev1*10+temp;
            num=num/10;
        }
        //System.out.println("Rev1"+rev1);
        while(rev1>0){
            int temp=rev1%10;
            rev2=rev2*10+temp;
            rev1=rev1/10;
        }
        //System.out.println("Rev2"+rev2);
        return rev2==initial?true:false;
    }
}  
