import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;
import java.lang.*;

class Problem2500{
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
        
        int[][] nums=new int[2][3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j]=scan.nextInt();
            }
            //nums[i]=scan.nextInt();
        }
        int sol=deleteGreatestValue(nums);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int deleteGreatestValue(int[][] grid) {
        int sol=0;
        int counter=grid[0].length;
        int globalMax=0;
        int maxValue=-1;
        List<Integer> list=new ArrayList<>();
        while(counter--!=0){
        list.clear();
        for (int i = 0; i < grid.length; i++) {
            int indexRow=0;
            int indexCol=0;
            maxValue=0;
            //list.clear();
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]>maxValue){
                    maxValue=grid[i][j];
                    indexRow=i;
                    indexCol=j;
                }
            }
            list.add(maxValue);
            grid[indexRow][indexCol]=-1;
        }
        Collections.sort(list);
        Collections.reverse(list);
        globalMax+=list.get(0);
        }
        return globalMax;
    }
}  