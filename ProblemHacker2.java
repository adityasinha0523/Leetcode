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

class ProblemHacker2{
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

        
        int costPerCut = 100;
        int salePrice = 10;
        //int[] lengths = {26, 103, 59};
        List<Integer> lengths=new ArrayList<>();
        lengths.add(26);
        lengths.add(103);
        lengths.add(59);
        
        System.out.println(maxProfit(costPerCut, salePrice, lengths));
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
        //System.out.println(5/3);
        //System.out.println(sol);
        scan.close();
    }  

        public static int maxProfit(int costPerCut, int salePrice, List<Integer> lengths) {
            int maxProfit = 0; 
            // Find the maximum length of rod to consider as saleLength
            int maxLength = 0;
            for (int length : lengths) {
                maxLength = Math.max(maxLength, length);
            }
            
            // Iterate through all possible saleLengths
            for (int saleLength = 1; saleLength <= maxLength; saleLength++) {
                int totalCuts = 0;
                int totalUniformRods = 0;
                
                for (int length : lengths) {
                    int cuts = 0;
                    // If the rod can be divided into at least one piece of saleLength
                    if (length >= saleLength) {
                        Math.floor(totalUniformRods)
                        int uniformRods = length / saleLength;
                        totalUniformRods += uniformRods;
                        
                        // Calculate cuts required for this rod
                        if (length % saleLength == 0) {
                            cuts = uniformRods - 1;
                        } else {
                            cuts = uniformRods;
                        }
                    }
                    totalCuts += cuts;
                }
                
                // Calculate profit for this saleLength
                int profit = totalUniformRods * saleLength * salePrice - totalCuts * costPerCut;
                maxProfit = Math.max(maxProfit, profit);
            }
            return maxProfit;
        }
        
        
        
    
    
}  
