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

class problem150{
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

        //String xValue=Integer.toBinaryString(5);
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
    
    
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s=tokens[i];
            if(s.equals("+")){
                int val1=stack.pop();
                int val2=stack.pop();
                stack.add(val1+val2);
            }else if(s.equals("-")){
                int val1=stack.pop();
                int val2=stack.pop();
                stack.add(val1-val2);
            }else if(s.equals("*")){
                int val1=stack.pop();
                int val2=stack.pop();
                stack.add(val1*val2);
            }else if(s.equals("/")){
                int val1=stack.pop();
                int val2=stack.pop();
                stack.add(val1/val2);
            }else{
                stack.add(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }


    public static int evalRPN2(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s=tokens[i];
            if(s.length()==1 && s.equals("+")){
                int val1=stack.pop();
                int val2=stack.pop();
                stack.add(val1+val2);
            }else if(s.length()==1 && s.equals("-")){
                int val1=stack.pop();
                int val2=stack.pop();
                stack.add(val2-val1);
            }else if(s.length()==1 && s.equals("*")){
                int val1=stack.pop();
                int val2=stack.pop();
                stack.add(val1*val2);
            }else if(s.length()==1 && s.equals("/")){
                int val1=stack.pop();
                int val2=stack.pop();
                stack.add(val2/val1);
            }else{
                stack.add(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}  