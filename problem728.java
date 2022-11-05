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

class problem728{
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
        List<Integer> sol=selfDividingNumbers(47, 85);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        for (int i = 0; i < sol.size(); i++) {
            System.out.println(sol.get(i));
        }
        //System.out.println(sol);
        scan.close();
    }  

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> solution=new ArrayList<>();
        for (int i = left; i <=right; i++) {
            int value=i;
            int store=value;
            List<Integer> allIndex=new ArrayList<>();
            while(value!=0){
                int temp=value%10;
                value=value/10;
                allIndex.add(temp);
            }
            boolean found=false;
            for (int j = 0; j < allIndex.size(); j++) {
                int k=allIndex.get(j);
                if(allIndex.contains(0)){
                    found=true;
                    break;
                }
                if(store%k!=0){
                    found=true;
                }
            }
            if(found==false){
                solution.add(store);
            }
        }
        return solution;
    }
}  
