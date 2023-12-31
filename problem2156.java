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

class problem2156{
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
        /*
         * "xmmhdakfursinye"
96
45
15
21
         */
        String sol=subStrHash("xmmhdakfursinye",96,45,15,21);
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
        System.out.println(sol);
        scan.close();
    }  

    public static String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb=new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
                int length=sb.length();
                if(length>k){
                    break;
                }
                else if(length<k){
                    continue;
                }
                int temp=length;
                int p=0;
                long sum=0l;
                int count=0;
                while(length!=0){
                    int charVal=sb.charAt(p)-'a'+1;
                    double value=(double)Math.pow(power, count)%modulo;
                    sum+=value*charVal;
                    sum=sum%modulo;
                    length--;
                    count++;
                    p++;
                }
                if(sum%modulo==hashValue && temp==k){
                    return sb.toString();
                }
            }
        }
        return " ";
    }
}  