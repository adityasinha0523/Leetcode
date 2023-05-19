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

class problem2678{
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
        
        String[] nums=new String[2];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextLine();
        }
        int sol=countSeniors(nums);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int countSeniors(String[] details) {
        int solution=0;
        for (int i = 0; i < details.length; i++) {
            StringBuilder sb=new StringBuilder();
            String detail=details[i];
            sb.append(detail.charAt(11));
            sb.append(detail.charAt(12));
            int val=Integer.parseInt(sb.toString());
            System.out.println("Value"+val);
            if(val>60){
                solution++;
            }
        }
        
        return solution;
    }
}  