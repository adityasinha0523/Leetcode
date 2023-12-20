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

class problem2105{
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
        int[] nums=new int[5];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }

        //Taking 2D Array as input
        /*int[][] nums=new int[3][3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                nums[i][j]=scan.nextInt();
            }
        }*/

        //Taking String as input.
        //String s=scan.nextLine();
        int sol=minimumRefill(nums,6,5);

        //Printing 1D Array.
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int start=0;
        int end=plants.length-1;
        int solution=0;
        int initialA=capacityA;
        int initialB=capacityB;
        boolean conditionA=false;
        boolean conditionB=false;
        while(start<end){
            if(plants[start]<=capacityA){
                capacityA=capacityA-plants[start];
                conditionA=true;
            }if(plants[start]>capacityA &&conditionA==false){
                capacityA=initialA;
                capacityA=capacityA-plants[start];
                solution++;
            }
            if(plants[end]<=capacityB){
                capacityB=capacityB-plants[end];
                conditionB=true;
            }
            if(plants[end]>capacityB && conditionB==false){
                capacityB=initialB;
                capacityB=capacityB-plants[end];
                solution++;
            }
            conditionA=false;
            conditionB=false;
            start++;
            end--;
        }
        if(plants.length%2!=0){
            int max=Math.max(capacityA,capacityB);
            if(max<plants[start]){
                solution++;
            }
        }
        return solution;
    }
}  