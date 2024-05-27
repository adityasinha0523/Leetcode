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

class WC399{
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
        int[] arr1=new int[1];
        arr1[0]=1;
        
        int[] arr2=new int[1];
        arr2[0]=1;
        
        //System.out.println(sol);
        int sol=numberOfPairs(arr1, arr2, 2);
        System.out.println(sol);
        scan.close();
    }
    
    public static int numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> factorCounts = new HashMap<>();
        for (int num : nums2) {
            factorCounts.put(num, factorCounts.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (int num : nums1) {
            int[] factors=getFactors(num);
            for (int i = 0; i < factors.length; i++) {
                if(factors[i]%k==0){
                    count += factorCounts.getOrDefault(factors[i]/k, 0);
                }
            }
        }
        return count;
    }
    private static  int[] getFactors(int num) {
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                count += (i * i == num) ? 1 : 2;
            }
        }
        int[] factors = new int[count];
        count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                factors[count++] = i;
                if (i * i != num) {
                    factors[count++] = num / i;
                }
            }
        }
        return factors;
    }
}  