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

class problem491{
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
        
        int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        List<List<Integer>> sol=findSubsequences(nums);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        for (List<Integer> integer : sol) {
            System.out.println("Start");
            for (Integer list : integer) {
                System.out.println(list);
            }
            System.out.println("Break");
        }
        //System.out.println(sol);
        scan.close();
    }  

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> solution = new ArrayList<>();
        for (int i = 0; i < nums.length-1; i++) {
            int index=i;
            List<Integer> list=new ArrayList<>();
            list.add(nums[i]);
            for (int j = index+1; j < nums.length; j++) {
                boolean found=false;
                for (int j2 = j; j2 < nums.length; j2++) {
                    if(nums[j2]>=list.get(list.size()-1)){
                        list.add(nums[j2]);
                        if(list.size()>=2){
                            solution.add(list);
                        }
                    }else{
                        found=true;
                        list.clear();
                        list.add(nums[i]);
                        break;
                    }
                }
                
            }
        }
        return solution;
    }
}  