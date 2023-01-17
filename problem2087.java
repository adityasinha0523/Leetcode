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

class problem2087{
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
        int[] startPos=new int[2];
        startPos[0]=1;
        startPos[1]=3;
        int[] homePos=new int[2];
        homePos[0]=2;
        homePos[1]=0;
        int[] rowCosts=new int[3];
        rowCosts[0]=5;
        rowCosts[1]=4;
        rowCosts[2]=3;

        int[] colCosts=new int[4];
        colCosts[0]=8;
        colCosts[1]=2;
        colCosts[2]=6;
        colCosts[3]=7;
        int sol=minCost(startPos, homePos, rowCosts, colCosts);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int minCost1(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int res = 0, i = startPos[0], j = startPos[1], x = homePos[0], y = homePos[1];
        while (i != x) {
            int value=(x - i) / Math.abs(x - i);
            i += value;
            res += rowCosts[i];
        }
        while (j != y) {
            int value=(y - j) / Math.abs(y - j);
            j += value;
            res += colCosts[j];
        }
        return res;
    }

    public static int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int sol=0;
        int i=startPos[0];
        int j=startPos[1];
        int x=homePos[0];
        int y=homePos[1];
        while(i!=x){
            int value=(x-i)/Math.abs(x-i);
            i+=value;
            sol+=rowCosts[i];
        }
        while(j!=y){
            int value=(y-j)/Math.abs(y-j);
            j+=value;
            sol+=colCosts[j];
        }
        return sol;
    }
}  