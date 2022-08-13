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

class problem2011{
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
        //For reading integer from input file
        //int a=scan.nextInt();
        //String temp1="leetcodeisacommunityforcoders";
        //int temp2=4;
        /*int [] input=new int[4];
        for (int i = 0; i < input.length; i++) {
            input[i]=scan.nextInt();
        }*/

        
        //scan.nextLine();
        String[] string=new String[3];
        for (int i = 0; i < string.length; i++) {
            string[i]=scan.nextLine();
        }
        int sol=finalValueAfterOperations(string);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int finalValueAfterOperations(String[] operations) {
        int totalValue=0;
        for (int i = 0; i < operations.length; i++) {
            if(operations[i].charAt(0)=='+'){
                totalValue++;
            }else if(operations[i].charAt(0)=='-'){
                totalValue--;
            }else if(operations[i].charAt(0)=='X'){
                if(operations[i].charAt(1)=='+'){
                    totalValue++;
                }else{
                    totalValue--;
                }
            }
        }
        return totalValue;
    } 
}  