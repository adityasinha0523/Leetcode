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

class problem682{
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
        
        String[] nums=new String[5];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextLine();
        }
        
        int sol=calPoints(nums);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int calPoints(String[] operations) {
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < operations.length; i++) {
            char c=operations[i].charAt(0);
            if(Character.isDigit(c) ||c=='-'){
                int i1=Integer.parseInt(operations[i]);
                //stack.add(Character.getNumericValue(c));
                stack.add(i1);
            }else if(c=='+'){
                int first=stack.pop();
                int second=stack.pop();
                int sum=first+second;
                stack.add(second);
                stack.add(first);
                stack.add(sum);
            }else if(c=='C'){
                stack.pop();
            }else{
                int first=stack.pop();
                //int second=stack.pop();
                int product=first*2;
                stack.add(first);
                stack.add(product);
            }
        }
        int size=stack.size();
        int sol=0;
        for (int i = 0; i < size; i++) {
            sol+=stack.pop();
        }
        return sol;
    }
}  