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

class problem501{
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

    Map<Integer,Integer> map;
    public int[] findMode(TreeNode root) {
        map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        helper(root);
        int max=Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> map1:map.entrySet()){
            max=Math.max(max,map1.getValue());
        }
        for(Map.Entry<Integer,Integer> map1:map.entrySet()){
            if(map1.getValue()==max){
                list.add(map1.getKey());
            }
        }
        int k=0;
        int[] sol=new int[list.size()];
        for(Integer  int1:list){
            sol[k++]=int1;
        }
        return sol;
    }
    
    public void helper(TreeNode root){
        if(root!=null){
            map.put(root.val,map.getOrDefault(root.val,0)+1);
            helper(root.left);
            helper(root.right);
        }
    }
}  