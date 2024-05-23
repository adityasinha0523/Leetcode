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

class Contest{
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
    
    public static boolean[] isArraySpecial(int[] nums,int[][] queries) {
        List<List<Integer>> list=new ArrayList<>();
        boolean[] result=new boolean[queries.length];
        int n = nums.length;
        int[] oddCounts = new int[n + 1];
        int[] evenCounts = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            oddCounts[i] = oddCounts[i - 1] + (nums[i - 1] % 2 == 1 ? 1 : 0);
            evenCounts[i] = evenCounts[i - 1] + (nums[i - 1] % 2 == 0 ? 1 : 0);
        }
        for (int i = 0; i < oddCounts.length; i++) {
            System.out.println("OddCount");
            System.out.println(oddCounts[i]);
        }

        for (int i = 0; i < evenCounts.length; i++) {
            System.out.println("EvenCount");
            System.out.println(oddCounts[i]);
        }
        // Check each query
        int k=0;
        for (int[] query : queries) {
            int fromIndex = query[0];
            int toIndex = query[1];
            
            // Calculate the parity difference between endpoints of the subarray
            int oddDiff = oddCounts[toIndex] - oddCounts[fromIndex];
            int evenDiff = evenCounts[toIndex] - evenCounts[fromIndex];
            
            // Check if the subarray is special
            result[k++]=(oddDiff != 0 && evenDiff != 0);
            //result.add(oddDiff != 0 && evenDiff != 0);
        }
        return result;
        //return solution;
    }
}  