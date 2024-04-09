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

class problem739{
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
        int[] nums=new int[8];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }

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

        int[] sol=dailyTemperatures(nums);
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
        //System.out.println(sol);
        scan.close();
    }
    
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] solution=new int[temperatures.length];
        Stack<Integer> stack=new Stack<>();
        int k=temperatures.length-1;
        solution[k--]=0;
        stack.add(temperatures.length-1);
        for (int i = temperatures.length-2; i >=0; i--) {
            int val=stack.peek();
            if(temperatures[val]>temperatures[i]){
                int val2=stack.peek();
                int sol2=val2-i;
                solution[k]=sol2;
                k--;
                stack.add(i);
            }else{
                if(stack.isEmpty()){
                    solution[k]=0;
                    k--;
                }else{
                    while(!stack.isEmpty()){
                        int val1=stack.peek();
                        if(temperatures[val1]>temperatures[i]){
                            int sol=val1-i;
                            solution[k]=sol;
                            k--;
                            stack.add(i);
                            break;
                        }else{
                            stack.pop();
                        }
                    }
                    if(stack.isEmpty()){
                        stack.add(i);
                        solution[k--]=0;
                    }
                }
            }
        }
        return solution;
    }
}  
