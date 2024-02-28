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

class problem476{
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
        
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static int findComplement(int num) {
        int todo=num;
        int bit=1;
        while(todo!=0){
            num=num^bit;
            bit=bit<<1;
            todo=todo>>1;
        }
        return num;
    }
    
    public static int findComplement3(int num) {
        String s=Integer.toBinaryString(num);
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='1'){
                sb.append('0');
            }else{
                sb.append('1');
            }
        }
        String ans=sb.toString();
        int answer=0;
        int counter=0;
        for (int i = ans.length()-1; i >= 0; i--) {
            if(ans.charAt(i)=='1'){
                answer+=Math.pow(2,counter);
            }
            counter++;
        }
        return answer;
    }
}  
