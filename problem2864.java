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

class problem2864{
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

    public String maximumOddBinaryNumber(String s) {
        StringBuilder sb=new StringBuilder();
        int counter=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='1'){
                counter++;
            }
        }
        int counter2=0;
        for (int i = 0; i < s.length()-1; i++) {
            if(counter2<counter-1){
                sb.append("1");
                counter2++;
            }else{
                sb.append("0");
            }
        }
        sb.append("1");
        return sb.toString();
    }

    public String maximumOddBinaryNumber2(String s) {
        int countOne=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='1'){
                countOne++;
            }
        }
        int countZero=s.length()-countOne;
        StringBuilder sb=new StringBuilder();
        sb.append("1");
        countOne--;
        boolean allZero=false;
        for (int i = 1; i < s.length(); i++) {
            if(countZero!=0){
                sb.append("0");
                countZero--;
            }else{
                allZero=true;
            }
            if(allZero==true){
                sb.append("1");
            }
        }
        String sol=sb.reverse().toString();
        return sol;
    }
}  