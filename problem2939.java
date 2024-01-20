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

class problem2939{
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

    public static int maximumXorProduct(long a, long b, int n) {
        
        long xorA=0l;
        long xorB=0l;
        long MOD = 1000000000+7;
        for (int i = 49; i >=n; i--) {
            boolean aSet = ((a >> i) & 1)> 0; 
            boolean bSet = ((b >> i) & 1) > 0;  

            if(aSet == true)
            {
                xorA ^= (1L << i);
            } 

            if(bSet == true)
            {
                xorB ^= (1L << i);
            }
        }
        for (int i = n-1; i >=0; i--) {
            long valA=((a>>i)&1);
            long valB=((b>>i)&1);
            if(valA==valB){
                xorA=xorA^(1L<<i);
                xorB=xorB^(1L<<i);
                continue;
            }else{
                if(xorA>xorB){
                    xorB=xorB^(1L<<i);
                }else{
                    xorA=xorA^(1L<<i);
                }
            }
        }
        xorA=(xorA%MOD);
        xorB=(xorB%MOD);

        return (int)(xorA*xorB%MOD);
    }
}  
