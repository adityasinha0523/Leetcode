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

class problem2248{
    public static void main(String args[]) throws IOException{  
        if (System.getProperty("ONLINE_JUDGE") == null) {
            // Redirecting the I/O to external files
 
            // as ONLINE_JUDGE constant is not defined which
            // means
 
            // the code is not running on an online judge
 
            PrintStream ps
                = new PrintStream(new File("output.txt"));
            InputStream is
                = new FileInputStream("input.txt");
 
            System.setIn(is);
            System.setOut(ps);
        }
        Scanner scan = new Scanner(System.in);
        //For reading string from input file
        //String myLine = scan.nextLine();
        //scan.nextLine();
        //To take int array as input

        /*int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/
        int[][] nums=new int[2][3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j]=scan.nextInt();
            }
        }
       List<Integer> sol= intersection(nums);
       for (int i = 0; i < sol.size(); i++) {
            System.out.println(sol.get(i));
       }
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static List<Integer> intersection(int[][] nums) {
        Map<Integer,Integer> hMap=new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                hMap.put(nums[i][j], hMap.getOrDefault(nums[i][j], 0)+1);
            }
        }
        int n=nums.length;
        List<Integer> solution=new ArrayList<>();
        for (Map.Entry<Integer,Integer> hEntry : hMap.entrySet()) {
            if(hEntry.getValue()==n){
                solution.add(hEntry.getKey());
            }
        }
        return solution;
    }
}
