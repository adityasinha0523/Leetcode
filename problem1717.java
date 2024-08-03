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

class problem1717{
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
    
    
    public int maximumGain(String s, int x, int y) {
        int res=0;
        String top,bottom;
        int top_score,bottom_score;
        if(y>x){
            top="ba";
            top_score=y;
            bottom="ab";
            bottom_score=x;
        }else{
            top="ab";
            top_score=x;
            bottom="ba";
            bottom_score=y;
        }
        StringBuilder sb=new StringBuilder();
        for (char ch : s.toCharArray()) {
            if(ch==top.charAt(1) &&sb.length()>0 &&sb.charAt(sb.length()-1)==top.charAt(0)){
                res+=top_score;
                sb.setLength(sb.length()-1);
            }else{
                sb.append(ch);
            }
        }

        StringBuilder sb1=new StringBuilder();
        for (char ch : sb.toString().toCharArray()) {
            if(ch==bottom.charAt(1) &&sb1.length()>0 &&sb1.charAt(sb1.length()-1)==bottom.charAt(0)){
                res+=bottom_score;
                sb1.setLength(sb1.length()-1);
            }else{
                sb1.append(ch);
            }
        }
        return res;
    }
}  