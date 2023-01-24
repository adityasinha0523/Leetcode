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
import java.nio.file.NotLinkException;

class problemLC1{
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
        int sol=alternateDigitSum(886996);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int alternateDigitSum(int n) {
        int n1=0;
        int temp=n;
        while(temp!=0){
            temp=temp/10;
            n1++;
        }
        int sum=0;
        int sign=1;
        if(n1%2==0){
            sign=-1;
        }
        int counter=0;
        while(n!=0){
            int temp1=n%10;
            sum=sum+sign*temp1;
            if(counter%2==0){
                sign=sign*-1;
            }else{
                sign=sign*1;
            }
            n=n/10;
        }
        return sum;
    }
}  