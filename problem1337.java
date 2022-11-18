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
import java.util.Map.Entry;
import java.lang.*;

class problem1337{
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
        
        int[][] nums=new int[5][5];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                nums[i][j]=scan.nextInt();
            }
            //nums[i]=scan.nextInt();
        }
        int[] sol=kWeakestRows(nums, 3);
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static int[] kWeakestRows(int[][] mat, int k) {
        //PriorityQueue<Integer> pq=new PriorityQueue<>();
        TreeMap<Integer,Integer> tMap=new TreeMap<>();
        int size=mat[0].length;
        for (int j = 0; j < mat.length; j++) {
            int[] integer=mat[j];
            int count=0;
            for (int i = 0; i < integer.length; i++) {
                if(integer[i]==1){
                    count++;
                }
            }
            tMap.put(count, j);
        }
        int counter=0;
        int index=0;
        int[] sol=new int[k];
        for (Entry<Integer, Integer> hEntry: tMap.entrySet()) {
            if(counter<k){
                int value=hEntry.getValue();
                sol[index++]=value;
                counter++;
            }
        }
        return sol;
    }
}  