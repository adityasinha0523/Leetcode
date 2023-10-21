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

class problem541{
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

    public static String reverseStr(String s, int k) {
        int counter=0;
        boolean reverse=true;
        StringBuilder sb=new StringBuilder();
        StringBuilder sol=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
             counter++;
            if(reverse==true && counter<=k){
                sb.append(s.charAt(i));
            }else if(counter>k){
                if(reverse==true){
                    sol.append(sb.reverse().toString());
                    sb.delete(0, sb.length());
                    sol.append(s.charAt(i));
                }else{
                    sb.append(s.charAt(i));
                }
                if(reverse==false){
                    reverse=true;
                }else{
                    reverse =false;
                }
                counter=1;    
            }else{
                sol.append(s.charAt(i));
            }
           
        }
        if(sb.length()!=0){
            sol=sol.append(sb.reverse().toString());
        }
        return sol.toString();
    }
}  