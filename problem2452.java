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

class problem2452{
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

    public static List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> solution= new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            String s=queries[i];
            for (int j = 0; j < dictionary.length; j++) {
                String k=dictionary[j];
                int counter=0;
                if(s.length()==k.length()){
                    for (int k2 = 0; k2 < k.length(); k2++) {
                        if(k.charAt(k2)!=s.charAt(k2)){
                            counter++;
                        }
                    }
                }
                if(counter<=2){
                    solution.add(s);
                    break;
                }
            }
        }
        return solution;
    }
}  