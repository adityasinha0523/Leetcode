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

class problem1431{
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
        //For reading integer from input file
        //int a=scan.nextInt();
        //String temp1="leetcodeisacommunityforcoders";
        //int temp2=4;
        /*int [] input=new int[4];
        for (int i = 0; i < input.length; i++) {
            input[i]=scan.nextInt();
        }*/

        
        //scan.nextLine();
        //To take array as input
        int[] candies=new int[3];
        for (int i = 0; i < candies.length; i++) {
            candies[i]=scan.nextInt();
        }
        int extraCandies=scan.nextInt();
        List<Boolean> sol=kidsWithCandies(candies, extraCandies);
        for(int i=0;i<sol.size();i++){
            System.out.println(sol.get(i));
        }
        //System.out.println(sol);
        scan.close();
    }  

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxValues=Integer.MIN_VALUE;
        List<Boolean> solution=new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            maxValues=Math.max(candies[i], maxValues);
        }
        for (int i = 0; i < candies.length; i++) {
            if(candies[i]+extraCandies>=maxValues){
                solution.add(true);
            }else{
                solution.add(false);
            }
        }
        return solution;
    }
}  
