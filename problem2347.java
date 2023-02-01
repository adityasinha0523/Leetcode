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

class problem2347{
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
        
        /*int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/
        
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static String bestHand(int[] ranks, char[] suits) {
        int count=1;
        char current=suits[0];
        for (int i = 1; i < suits.length; i++) {
            if(suits[i]==current){
                count++;
            }
            
        }
        if(count==5){
            return "Flush";
        }
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < ranks.length; i++) {
            map.put(ranks[i], map.getOrDefault(ranks[i], 0)+1);
        }
        boolean gotPair=false;
        for (Map.Entry<Integer,Integer> hEntry : map.entrySet()) {
            int value=hEntry.getValue();
            if(value>=3){
                return"Three of a Kind";
            }
            if(value==2){
                gotPair=true;
            }
        }
        if(gotPair==true){
            return "Pair";
        }
        return "High Card";
    }
}  