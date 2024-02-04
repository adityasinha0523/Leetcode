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

class BWC123P2{
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
        int[][] nums=new int[3][2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j]=scan.nextInt();
            }
        }

        //Taking String as input.
        //String s=scan.nextLine();

        int sol=numberOfPairs(nums);
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

    public static int numberOfPairs(int[][] points) {
        int count = 0;
        int n = points.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int chisatoX = points[i][0];
                    int chisatoY = points[i][1];
                    int takinaX = points[j][0];
                    int takinaY = points[j][1];

                    // Check if Chisato's position is upper left and Takina's is lower right
                    if (chisatoX <= takinaX && chisatoY >= takinaY) {
                        boolean valid = true;

                        for (int k = 0; k < n; k++) {
                            if (k != i && k != j) {
                                int otherX = points[k][0];
                                int otherY = points[k][1];

                                // Check if any other point is inside or on the boundary of the rectangle
                                if (otherX >= chisatoX && otherX <= takinaX && otherY <= chisatoY && otherY >= takinaY) {
                                    valid = false;
                                    break;
                                }
                            }
                        }

                        if (valid) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}  