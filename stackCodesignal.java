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

class stackCodesignal{
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
        char[][] input={
        {'1','+','3','-','2'},
        {'2','+','5','+','+'},
        {'1','-','4','-','9'},
        {'+','2','-','7','+'},
        {'2','+','5','+','9'},
        {'+','1','+','8','+'},
        {'2','-','0','-','9'}
        };
        /*int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/
        int sol=solution(input);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int solution(char[][] puzzle){
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < puzzle.length; i++) {
            Stack<Integer> stack=new Stack<>();
            int sum=0;
            char symbol='x';
            for (int j = 0; j < puzzle[0].length; j++) {
                if(stack.isEmpty()){
                    if(!Character.isDigit(puzzle[i][j])){
                        break;
                    }
                    stack.add(Character.getNumericValue(puzzle[i][j]));
                    continue;
                }else if(!Character.isDigit(puzzle[i][j])){
                    symbol=puzzle[i][j];
                    continue;
                }else if(stack.size()==1){
                    if(symbol!='x'){
                        //int firstValue=stack.pop();
                        int val=stack.pop();
                        if(symbol=='+'){
                            sum=Character.getNumericValue(puzzle[i][j])+val;
                            int answer=sum;
                            stack.add(answer);
                        }else{
                            sum=val-Character.getNumericValue(puzzle[i][j]);
                            int answer=sum;
                            stack.add(answer);
                        }
                    }else{
                        break;
                    }                
                }
            }
            if(!stack.isEmpty()){
                
                int val=stack.pop();
                //int val=Character.getNumericValue(c);
                max=Math.max(max, val);
            }
        }
        for (int j = 0; j < puzzle[0].length; j++) {
            Stack<Integer> stack=new Stack<>();
            int sum=0;
            char symbol='x';
            for (int i = 0; i < puzzle.length; i++) {
                if(stack.isEmpty()){
                    if(!Character.isDigit(puzzle[i][j])){
                        break;
                    }
                    stack.add(Character.getNumericValue(puzzle[i][j]));
                    continue;
                }else if(!Character.isDigit(puzzle[i][j])){
                    symbol=puzzle[i][j];
                    continue;
                }else if(stack.size()==1){
                    if(symbol!='x'){
                        //int firstValue=stack.pop();
                        int val=stack.pop();
                        if(symbol=='+'){
                            sum=Character.getNumericValue(puzzle[i][j])+val;
                            int answer=sum;
                            stack.add(answer);
                        }else{
                            sum=val-Character.getNumericValue(puzzle[i][j]);
                            int answer=sum;
                            stack.add(answer);
                        }
                    }else{
                        break;
                    }                
                }
            }
            if(!stack.isEmpty()){
                
                int val=stack.pop();
                //int val=Character.getNumericValue(c);
                max=Math.max(max, val);
            }
        }
        return max;
    }
}  