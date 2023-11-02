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

class problem2869{
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

    public static int minOperations(List<Integer> nums, int k) {
        List<Integer> newList=new ArrayList<>(nums);
        Collections.sort(newList);
        int solution=0;
        Map<Integer,Integer> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        List<Integer> listSol=new ArrayList<>();
        for (int i = 0; i < newList.size(); i++) {
            if(!set.contains(newList.get(i))){
                listSol.add(newList.get(i));
                set.add(newList.get(i));
            }
        }
        for (int i = 0; i < nums.size(); i++) {
            map.put(nums.get(i), i);
        }
        for (int i = 0; i < k; i++) {
            int val=listSol.get(i);
            int index=map.get(val);
            solution=Math.max(solution, nums.size()-index);
        }
        return solution;
    }

    //2nd and better solution
    public int minOperations2(List<Integer> nums, int k) {
        int total_op = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = nums.size() - 1; i >= 0; i--) {
            total_op++;
            if (nums.get(i) <= k) {
                set.add(nums.get(i));
            } 
            if(set.size()==k)break;
        }

        return total_op;
    }
}  