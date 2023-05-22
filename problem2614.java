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

class problem2614{
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
        
        int[][] nums=new int[3][3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j]=scan.nextInt();
            }
        }
        int sol=diagonalPrime(nums);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int diagonalPrime(int[][] nums) {
        int solution=0;
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if(i==j){
                    list.add(nums[i][j]);
                }
            }
        }
        int k=nums.length-1;
        int l=nums[0].length-1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if(j==l){
                    list.add(nums[i][j]);
                    k--;
                    l--;
                }
            }
        }
        for (Integer integer : list) {
            boolean isNotPrime=false;
            isNotPrime=isPrime(integer);
            if(isNotPrime==true){
                if(integer>solution){
                    solution=integer;
                }
            }
        }
        return solution;
    }

    public static boolean isPrime(int n) {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        int sqrtN = (int)Math.sqrt(n);
        for(int i = 2; i <= sqrtN; i += 1) {
            if(n%(i) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }
}  