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

class problem2409{
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


        //Printing 1D Array.
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static int countDaysTogether(String aA, String lA, String aB, String lB) {
        String from = "";
        if(aA.compareTo(aB) <= 0) {
            from = aB;
        }else{
            from = aA;
        }
        String to = "";
        if(lA.compareTo(lB) <= 0) {
            to = lA;
        }else{
            to = lB;
        }
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int aM = Integer.parseInt(from.substring(0,2));   // aM = arriveMonth
        int aD = Integer.parseInt(from.substring(3));    // aD = arriveDate
        int lM = Integer.parseInt(to.substring(0,2));    //lM = leaveMonth
        int lD = Integer.parseInt(to.substring(3));      //lD = leaveDate
        if(lM < aM) return 0;                                  
        else if(aM == lM && aD>lD) return 0;        
        else if(aM == lM && aD<=lD) {
            return lD-aD+1;
        }else{
        int k = lM-aM-1;
            int cntDays = 0;
            int temp = aM;
            while(k-->0) {
                cntDays+=days[temp++];
            }
            return cntDays+(days[aM-1]-aD)+lD+1;
        }
    }
}  