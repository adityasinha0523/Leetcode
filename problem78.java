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

class problem78{
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
        //System.out.println(sol);
        scan.close();
    }  

    /*public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sol=new ArrayList<>();
        Arrays.sort(nums);
        helper(sol,new ArrayList<>(),nums,0);
        return sol;
    }

    public static void helper(List<List<Integer>> sol,List<Integer> temp,int[] nums ,int start){
        sol.add(temp);
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(sol, temp, nums, start+1);
            temp.remove(nums[i]);
        }
    }*/

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sol=new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> temp=new ArrayList<>();
        backtrack(sol,nums,temp,0);
        return sol;
    }

    void backtrack(List<List<Integer>> sol,int[]nums,List<Integer> temp,int index){
        sol.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(sol, nums, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
}  
