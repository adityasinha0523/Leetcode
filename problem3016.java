

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

class problem3016{
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

}  
public static int minimumPushes(String word) {
    Map<Character,Integer> map=new HashMap<>();
    int[] count=new int[26];
    for (int i = 0; i < word.length(); i++) {
        count[word.charAt(i)-'a']++;
        map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0)+1);
    }
    PriorityQueue<Map.Entry<Character, Integer>> pq1 = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
    pq1.addAll(map.entrySet());
    int counter=0;
    int solution=0;
    while (!pq1.isEmpty()) {
        counter++;
        Map.Entry e = pq1.poll();
        int value=(int) e.getValue();
        Character key=(Character) e.getKey();
        if(counter>24){
            solution+=4*value;
        }else if(counter>16){
            solution+=3*value;
        }else if(counter>8){
            solution+=2*value;
        }else{
            solution+=1*value;
        }
        
    }
    return solution;
}
