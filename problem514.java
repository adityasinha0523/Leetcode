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

class problem514{
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

    
    public static int findRotateSteps(String ring, String key) {
        char[] ringArr=ring.toCharArray();
        char[] keyArr=key.toCharArray();
        int[][] dp=new int[ringArr.length][keyArr.length];
        return dfs(ringArr,keyArr,0,0,dp);

    }

    public int dfs(char[] ring,char[] target,int targetIndex,
    int ringIndex,int[][] memo){
        if(targetIndex==target.length){
            return 0;
        }
        if(memo[ringIndex][targetIndex]!=0){
            return memo[ringIndex][targetIndex];
        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < ring.length; i++) {
            if(ring[i]!=target[targetIndex]){
                continue;
            }
            int dif=Math.abs(i-ringIndex);
            int distance=1+Math.min(dif, ring.length-dif)+
            dfs(ring,target,targetIndex+1,i,memo);
            min=Math.min(min, distance);
        }
        memo[ringIndex][targetIndex]=min;
        return min;
    }
}  