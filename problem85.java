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

class problem85{
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
    
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int maxArea=0;
        int row=matrix.length;
        int col=matrix[0].length;
        int[] dp=new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[j]=matrix[i][j]=='1'?dp[j]+1:0;
            }
            maxArea=Math.max(maxArea, findArea(dp));
        }
        return maxArea;
    }

    public int findArea(int[] dp){
        int len=dp.length;
        int maxArea=0;
        int[] left=new int[len];
        int[] right=new int[len];
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < len; i++) {
            if(stack.isEmpty()){
                stack.push(i);
                left[i]=0;
            }else{
                while(!stack.isEmpty()&& dp[stack.peek()]>=dp[i]){
                    stack.pop();
                }
                left[i]=stack.isEmpty()?0:stack.peek()+1;
                stack.add(i);
            }
        }
        while(!stack.isEmpty()){
            stack.pop();
        }
        for (int i = len-1; i >=0; i--) {
            if(stack.isEmpty()){
                stack.push(len-1);
                right[i]=len-1;
            }else{
                while(!stack.isEmpty()&& dp[stack.peek()]>=dp[i]){
                    stack.pop();
                }
                right[i]=stack.isEmpty()?len-1:stack.peek()-1;
                stack.add(i);
            }
        }
        int[] area=new int[len];
        for (int i = 0; i < len; i++) {
            area[i]=(right[i]-left[i])*dp[i];
            maxArea=Math.max(maxArea, area[i]);
        }
        return maxArea;
    }

}  