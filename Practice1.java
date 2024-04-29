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

class Practise1{
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

        //String xValue=Integer.toBinaryString(5);
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
        List<Integer> nums=new ArrayList<>();
        nums.add(2);
        nums.add(4);
        nums.add(3);
        nums.add(1);
        nums.add(6);
        int solution=findRequestsInQueue(nums);
        System.out.println(solution);
        scan.close();
    } 
    
    public static List<Integer> findRequestsInQueue(List<Integer> wait) { 
        int requests = wait.size(); 
        Map<Integer, Integer> counts = new HashMap<>();
        for (int time : wait) {
            counts.compute(time, (k, v) -> v == null ? 1 : v + 1);
        }

        int n = wait.size();
        int[] result = new int[n];
        int time = 0; // real / running time
        for (int waitingTime : wait) {
            if (waitingTime > time) {
                result[time++] = requests--;
                counts.compute(waitingTime, (k, v) -> v == 1 ? null : v - 1);
            }
            Integer noOfReqExpired = counts.remove(time);
            if (noOfReqExpired != null) {
                requests -= noOfReqExpired;
            }
        }
        List<Integer> solution=new ArrayList<>();
        boolean found=false;
        for (int i = 0; i < result.length; i++) {
            if(result[i]==0 &&found==false){
                solution.add(result[i]);
                found=true;
            }else{
                
            }
            solution.add(result[i]);
        }
        return solution;
    }
}  