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
        Set<List<Integer>> res=new HashSet<>();
        List<Integer> holder=new ArrayList<>();
        findSubsequence(res,holder,0,nums);
        List<List<Integer>> result=new ArrayList<>(res);
        return result;
    }

    public void findSubsequence(Set<List<Integer>> res,List<Integer>holder,int index,int[]nums){
        if(holder.size()>=2){
            res.add(new ArrayList<>(holder));
        }
        for (int i = index; i < nums.length; i++) {
            if(holder.size()==0||holder.get(holder.size()-1)<=nums[i]){
                holder.add(nums[i]);
                findSubsequence(res, holder, i+1, nums);
                holder.remove(holder.size()-1);
            }
        }
    }
}  