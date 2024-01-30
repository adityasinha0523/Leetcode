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

class problem39{
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

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        findCombination(0,candidates,target,ans,list);
        return ans;
    }

    public static void findCombination(int ind,int[] arr,int target,List<List<Integer>> ans,List<Integer> ds){
        /*if(ind==arr.length){
            if(target==0){
                List<Integer> answer=new ArrayList<>(ds);
                ans.add(answer);
            }
            return;
        }
        if(arr[ind]<=target){
            ds.add(arr[ind]);
            findCombination(ind, arr, target-arr[ind], ans, ds);
            ds.remove(ds.size()-1);
        }
        findCombination(ind+1, arr, target, ans, ds);*/

        if(ind==arr.length){
            if(target==0){
                List<Integer> answer=new ArrayList<>(ds);
                ans.add(answer);
            }
            return;
        }
        if(arr[ind]<=target){
            ds.add(arr[ind]);
            findCombination(ind, arr, target-arr[ind], ans, ds);
            ds.remove(ds.size()-1);
        }
        findCombination(ind+1, arr, target, ans, ds);
    }
}  