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

class problem1544{
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


        //Printing 1D Array.
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    } 
    
    

    public static String makeGood(String s) {
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(!stack.isEmpty()){
                if(Character.isUpperCase(c)){
                    char stackChar=stack.peek();
                    if(Character.isLowerCase(stackChar)&& Character.toLowerCase(c)==stackChar){
                        stack.pop();
                    }else{
                        stack.add(c);
                    }
                }else{
                    char stackChar=stack.peek();
                    if(Character.isUpperCase(stackChar)&& Character.toUpperCase(c)==stackChar){
                        stack.pop();
                    }else{
                        stack.add(c);
                    }
                }
            }else{
                stack.add(c);
            }
        }
        if(stack.isEmpty()){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }

    public static String makeGood(String s) {
        StringBuilder sb=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.size()!=0){
                Character c=stack.peek();
                int first=c;
                int second=s.charAt(i);
                int diff=Math.abs(second-first);
                if(diff==32){
                    stack.pop();
                }else{
                    stack.add(s.charAt(i));
                }
            }else{
                stack.add(s.charAt(i));
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}  