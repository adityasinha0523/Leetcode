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

class problem661{
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
        int[][] sol=imageSmoother(nums);

        //Printing 1D Array.
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/

        /*for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.println( sol[i][j]);
            }
        }*/

        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static int[][] imageSmoother(int[][] img) {
        int[][] sol=new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            int counter=0;
            int sum=0;
            for (int j = 0; j < img[0].length; j++) {
                int indexI=i;
                int indexJ=j;
                counter=1;
                sum=img[i][j]; 
                //Case1
                if(indexI-1>=0 && indexJ-1>=0){
                    sum+=img[indexI-1][indexJ-1];
                    counter++;
                }
                //Case2
                if(indexI-1>=0 && indexJ>=0){
                    sum+=img[indexI-1][indexJ];
                    counter++;
                }
                //Case3
                if(indexI-1>=0 &&indexJ+1<img[0].length){
                    sum+=img[indexI-1][indexJ+1];
                    counter++;
                }
                //Case4
                if(indexI>=0 &&indexJ-1>=0){
                    sum+=img[indexI][indexJ-1];
                    counter++;
                }
                //Case5
                if(indexI>=0 &&indexJ+1<img[0].length){
                    sum+=img[indexI][indexJ+1];
                    counter++;
                }
                //Case6
                if(indexI+1<img.length&&indexJ-1>=0){
                    sum+=img[indexI+1][indexJ-1];
                    counter++;
                }
                //Case 7
                if(indexI+1<img.length&&indexJ>=0){
                    sum+=img[indexI+1][indexJ];
                    counter++;
                }
                //Case 8
                if(indexI+1<img.length&&indexJ+1<img[0].length){
                    sum+=img[indexI+1][indexJ+1];
                    counter++;
                }
                sol[i][j]=(int)Math.floor(sum/counter);
            }
        }
        return sol;
    }
}  