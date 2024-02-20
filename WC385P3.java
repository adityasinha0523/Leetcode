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

class WC385P3{
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
        int[][] nums=new int[3][3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                nums[i][j]=scan.nextInt();
            }
        }

        //Taking String as input.
        //String s=scan.nextLine();

        int sol=mostFrequentPrime(nums);
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
        System.out.println(sol);
        scan.close();
    }  

    private static final int[][] directions = {
        {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}
    };

    public static int mostFrequentPrime(int[][] mat) {
        Map<Integer, Integer> primeCount = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                for (int[] dir : directions) {
                    generateAndCountPrimes(mat, i, j, dir, primeCount);
                }
            }
        }

        int maxCount = 0;
        int maxPrime = -1;
        for (Map.Entry<Integer, Integer> entry : primeCount.entrySet()) {
            if (entry.getValue() > maxCount || (entry.getValue() == maxCount && entry.getKey() > maxPrime)) {
                maxCount = entry.getValue();
                maxPrime = entry.getKey();
            }
        }
        return maxPrime;
    }

    private static void generateAndCountPrimes(int[][] mat, int x, int y, int[] dir, Map<Integer, Integer> primeCount) {
        long num = 0;
        int dx = x, dy = y;
        while (dx >= 0 && dy >= 0 && dx < mat.length && dy < mat[0].length) {
            num = num * 10 + mat[dx][dy];
            if (num > 10 && isPrime(num)) {
                primeCount.put((int)num, primeCount.getOrDefault((int)num, 0) + 1);
            }
            dx += dir[0];
            dy += dir[1];
        }
    }

    private static boolean isPrime(long num) {
        if (num <= 1) return false;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}  