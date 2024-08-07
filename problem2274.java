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

class problem2274{
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

    public static int maxConsecutive(int bottom, int top, int[] special) {
        int solution=Integer.MIN_VALUE;
        Arrays.sort(special);
        solution=Math.max(solution, special[0]- bottom);
        for (int i = 1; i < special.length; i++) {
            solution=Math.max(solution, special[i]-special[i-1]-1);
        }
        solution=Math.max(solution, top-special[special.length-1]);
        return solution;
        /*int solution=0;
        //int k=0;
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < special.length; i++) {
            set.add(special[i]);
        }
        int counter=0;
        while(bottom!=top){
            if(set.contains(bottom)){
                solution=Math.max(solution, counter);
                counter=0;
            }else{
                counter++;
            }
            bottom++;
        }
        solution=Math.max(counter, solution);
        return solution;*/
    }
}  