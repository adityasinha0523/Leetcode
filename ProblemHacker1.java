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

class ProblemHacker1{
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
        int[] A = {12,3,5,7,13,12};
        //Taking String as input.
        //String s=scan.nextLine();

        String sol=plusMult(A);
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
        System.out.println(sol);
        scan.close();
    }  
        public static String plusMult(int[] A) {
            /*int[] A=new int[A1.size()];
            for (int i = 0; i < A1.size(); i++) {
                A[i]=A1.get(i);
            }*/
            int Reven = 0, Rodd = 0;
            
            // Calculate Reven
            long count=0; 
            for (int i = 0; i < A.length; i += 2) {
                if(count%2==0){
                    if(i==0){
                        Reven=A[i];
                    }else{
                        Reven=Reven+A[i];
                    }
                    Reven=Reven%2;
                    count++;
                }else{
                    Reven=Reven*A[i];
                    Reven=Reven%2;
                    count++;
                }
            }
            
            // Calculate Rodd
            long countOdd=0;
            for (int i = 1; i < A.length; i += 2) {
                if(countOdd%2==0){
                    if(i==0){
                        Rodd=A[i];
                    }else{
                        Rodd=Rodd+A[i];
                    }
                    Rodd=Rodd%2;
                    countOdd++;
                }else{
                    Rodd=Rodd*A[i];
                    Rodd=Rodd%2;
                    countOdd++;
                }
            }
            
            // Determine if A is odd, even, or neutral based on Reven and Rodd
            if (Reven > Rodd) return "EVEN";
            else if (Rodd > Reven) return "ODD";
            else return "NEUTRAL";
        }
}  