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

import apple.laf.JRSUIConstants.State;

import java.lang.*;

class problem2751{
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
    
    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
    int n=positions.length;
    List<Integer> ind=new ArrayList<>();
    for (int i = 0; i < n; i++) {
        ind.add(i);
    }
    Stack<Integer> stack=new Stack<>();
    Collections.sort(ind,(x,y)->Integer.compare(positions[x], positions[y]));
    for (int x : ind) {
        if(directions.charAt(x)=='L'){
            while(!stack.isEmpty()){
                int y=stack.peek();
                if(healths[x]==healths[y]){
                    healths[x]=0;
                    healths[y]=0;
                    stack.pop();
                    break;
                }
                if(healths[x]>healths[y]){
                    healths[x]--;
                    healths[y]=0;
                    stack.pop();
                }
                if(healths[x]<healths[y]){
                    healths[x]=0;
                    healths[y]--;
                    break;
                }
            }
        }else{
            stack.add(x);
        }
    }
    List<Integer> result=new ArrayList<>();
    for (int val : healths) {
        if(val!=0){
            result.add(val);
        }
    }
    return result;
    }
}  