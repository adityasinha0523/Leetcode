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

class problem2961{
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

    public  int power(int a , int b , int m){
        int x =a;
        int ans =1;
        while(b!=0){
            if(b%2 == 1){
                ans = (ans *x) %m ;
            }
            x = (x*x)%m;
            b/=2;
        }
        return ans;
        }
    
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<variables.length;i++){
            long res =0;
            int a = variables[i][0];
            int b = variables[i][1];
            int c = variables[i][2];
            int d = variables[i][3];
            res = (long)power(power(a,b ,10),c,d);
            if( (int)res== target)
                list.add(i);
            }
        return list;
    }
}  