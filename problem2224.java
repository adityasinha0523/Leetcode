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

class problem2224{
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
        /*for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.println( sol[i][j]);
            }
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static int convertTime(String current, String correct) {
        int currentVal=0;
        int correctVal=0;
        String[] s1=current.split(":");
        int hour1=Integer.valueOf(s1[0]);
        int min1=Integer.valueOf(s1[1]);
        currentVal=hour1*60+min1;
        String[] s2=correct.split(":");
        int hour2=Integer.valueOf(s2[0]);
        int min2=Integer.valueOf(s2[1]);
        correctVal=hour2*60+min2;
        int counter=0;
        while(currentVal<correctVal){
            int diff=correctVal-currentVal;
            if(diff>=60){
                currentVal+=60;
                counter++;
            }
            else if(diff>=15){
                currentVal+=15;
                counter++;
            }else if(diff>=5){
                currentVal+=5;
                counter++;
            }else{
                currentVal+=diff;
                counter+=diff;
            }
        }
        return counter;
    }
}  
