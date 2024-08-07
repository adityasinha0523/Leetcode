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
import java.util.Scanner;
import java.util.List;
import java.util.*;
import java.lang.*;

class problem1518{
    public static void main(String args[]) throws IOException{  
        if (System.getProperty("ONLINE_JUDGE") == null) {
            // Redirecting the I/O to external files
 
            // as ONLINE_JUDGE constant is not defined which
            // means
 
            // the code is not running on an online judge
 
            PrintStream ps
                = new PrintStream(new File("output.txt"));
            InputStream is
                = new FileInputStream("input.txt");
 
            System.setIn(is);
            System.setOut(ps);
        }
        Scanner scan = new Scanner(System.in);
        
        
        int sol=numWaterBottles(15,4);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int numWaterBottles(int numBottles, int numExchange) {
        /*int solution=numBottles;
        while(numBottles>=numExchange){
            int exchangeBottle=numBottles/numExchange;
            int remainingBottle=numBottles%numExchange;
            numBottles=exchangeBottle+remainingBottle;
            solution+=exchangeBottle;
        }
        return solution;*/

        int solution=numBottles;
        while(numBottles>=numExchange){
            int exchangeBottle=numBottles/numExchange;
            int remainingBottle=numBottles%numExchange;
            numBottles=exchangeBottle+remainingBottle;
            solution+=exchangeBottle;
        }

        return solution;
    }
}  
