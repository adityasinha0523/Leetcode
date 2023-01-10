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

class problem844{
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
        String s=scan.nextLine();
        String t=scan.nextLine();
        boolean sol=backspaceCompare(s,t);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> s1=new Stack<Character>();
        Stack<Character> t1=new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!='#'){
                s1.add(s.charAt(i));
            }else{
                if(!s1.isEmpty()){
                    s1.pop();
                }
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if(t.charAt(i)!='#'){
                t1.add(t.charAt(i));
            }else{
                if(!t1.isEmpty()){
                    t1.pop();
                }
            }
        }
        while(!s1.isEmpty() && !t1.isEmpty()){
            if(!s1.pop().equals(t1.pop())){
                return false;
            }
        }
        if(!s1.isEmpty()|| !t1.isEmpty()){
            return false;
        }
        return true;
    }
}  
