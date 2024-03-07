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

class problem15{
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
        
        int[] nums=new int[6];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        List<List<Integer>> sol=threeSum(nums);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> solution=new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int x=nums[j];
                int y=nums[k];
                int z=nums[i];
                if(x+y+z==0){
                    List<Integer> list=new ArrayList<>();
                    list.add(z);
                    list.add(x);
                    list.add(y);
                    solution.add(list);
                }
                else if(x+y+z<0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return new ArrayList<>(solution);
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> solution=new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int first=nums[i];
                int second=nums[j];
                int third=nums[k];
                if(first+second+third==0){
                    List<Integer> list=new ArrayList<>();
                    list.add(first);
                    list.add(second);
                    list.add(third);
                    solution.add(list);
                }
                if(first+second+third<0){
                    j=j+1;
                }else{
                    k=k-1;
                }
            }
        }
        return new ArrayList<>(solution);
    }
}  