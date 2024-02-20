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

class problem1642{
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

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        /*int solution=0;
        for (int i = 0; i < heights.length-1; i++) {
            if(heights[i]<heights[i+1]){
                int diff=heights[i+1]-heights[i];
                if(bricks>=diff){
                    solution++;
                    bricks=bricks-diff;
                }else{
                    if(ladders>0){
                        ladders--;
                        solution++;
                    }else{
                        return solution;
                    }
                }
            }else{
                solution++;
            }
        }
        return solution;*/
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < heights.length-1; i++) {
            if(heights[i+1]<heights[i]){
                continue;
            }
            bricks-=heights[i+1]-heights[i];
            pq.add(heights[i+1]-heights[i]);
            if(bricks<0){
                bricks+=pq.poll();
                if(ladders>0){
                    ladders--;
                }else{
                    return i;
                }
            }
        }
        return heights.length-1;
    }
}  