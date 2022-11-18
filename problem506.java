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

class problem506{
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
        
        String[] nums=new String[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextLine();
        }
        String[] sol=findRelativeRanks(null);
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < score.length; i++) {
            pq.add(score[i]);
        }
        String[] sol=new String[score.length];
        int counter=1;
        HashMap<Integer,String> hMap=new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            int key=pq.poll();
            if(counter==1){
                hMap.put(key,"Gold Medal");
            }else if(counter==2){
                hMap.put(key, "Silver Medal");
            }else if(counter==3){
                hMap.put(key,"Bronze Medal");
            }else{
                hMap.put(key,Integer.toString(counter));
            }
            counter++;
        }
        for (int i = 0; i < score.length; i++) {
            int value=score[i];
            sol[i]=hMap.get(value);
        }
        return sol;
    }
}  