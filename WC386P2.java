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

class WC386P2{
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

    public static long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long largestArea = 0;
        
        for (int i = 0; i < bottomLeft.length; i++) {
            for (int j = i + 1; j < bottomLeft.length; j++) {
                int intersectBottomLeftX = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int intersectBottomLeftY = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int intersectTopRightX = Math.min(topRight[i][0], topRight[j][0]);
                int intersectTopRightY = Math.min(topRight[i][1], topRight[j][1]);
                
                if (intersectBottomLeftX < intersectTopRightX && intersectBottomLeftY < intersectTopRightY) {
                    int sideLength = Math.min(intersectTopRightX - intersectBottomLeftX, intersectTopRightY - intersectBottomLeftY);
                    long area = (long) sideLength * sideLength;
                    
                    largestArea = Math.max(largestArea, area);
                }
            }
        }
        
        return largestArea;
    }
}  