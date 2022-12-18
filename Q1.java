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

class Q1{
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
        
        int[][] nums=new int[3][2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j]=scan.nextInt();
            }
            
        }
        int sol=solution(nums);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int solution(int[][] lamps){
        int sol=0;
        List<Integer> list=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for (int[] is : lamps) {
            int startingIndex=is[0];
            int range=is[1];
            int leftSide=startingIndex-range;
            int rightSide=startingIndex+range;
            for (int i = leftSide; i <=rightSide; i++) {
                map.put(i,map.getOrDefault(i, 0)+1);
                list.add(i);
            }
        }
        Collections.sort(list);
        int currentMax=0;
        for (int i = 0; i < list.size(); i++) {
            int value=map.get(list.get(i));
            if(value>currentMax){
                sol=list.get(i);
                currentMax=value;
            }
        }
        return sol;
    }
}  