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

class problem1249{
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
        String sol=minRemoveToMakeValid("lee(t(c)o)de)");
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static String minRemoveToMakeValid(String s) {
        Stack<Character> stack=new Stack<>();
        int bracket=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                if(bracket%2==0){
                    stack.add(s.charAt(i));
                    bracket++;
                }
            }else if(s.charAt(i)==')'){
                if(bracket%2!=0){
                    stack.add(s.charAt(i));
                    bracket--;
                }
            }else{
                stack.add(s.charAt(i));
            }
        }
        StringBuilder sb=new StringBuilder();
        int n=stack.size();
        for (int i = 0; i < n; i++) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}  
