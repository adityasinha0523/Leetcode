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

class problem2073{
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
        //For reading string from input file
        //String myLine = scan.nextLine();
        //scan.nextLine();
        //To take int array as input
        
        int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        int sol=timeRequiredToBuy(nums, 0);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int solution=0;
        while(true){
            for (int i = 0; i < tickets.length; i++) {
                    if(tickets[i]!=0){
                        tickets[i]=tickets[i]-1;
                        solution++;
                        if(i==k && tickets[i]==0){
                            return solution;
                        }
                    }
                
            }
        }
        //return solution;
    }

    public static int timeRequiredToBuy2(int[] tickets, int k) {
        int solution=0;
        while(true){
            for (int i = 0; i < tickets.length; i++) {
                if(i==k && tickets[i]==0){
                    return solution;
                }else{
                    if(tickets[i]!=0){
                        solution++;
                        tickets[i]-=1;
                    }
                    
                }
            }
        }
    }
}  