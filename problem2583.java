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

import javax.swing.tree.TreeNode;

import apple.laf.JRSUIConstants.State;

import java.lang.*;

class problem2583{
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
    
    public static long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> list=new ArrayList<>();
        Queue<TreeNode> stack=new LinkedList<TreeNode>();
        stack.add(root);
        stack.add(null);
        while(!stack.isEmpty()){
            long sum=0l;
            while(stack.peek()!=null){
                TreeNode val1=stack.remove();
                if(val1.left!=null){
                    stack.add(val1.left);
                }
                if(val1.right!=null){
                    stack.add(val1.right);
                }
                sum+=val1.val;
            }
            stack.remove();
            if(!stack.isEmpty()){
                stack.add(null);
            }
            list.add(sum);  
        }
        Collections.sort(list);
        Collections.reverse(list);
        if(k>list.size()){
            return -1;
        }
        return list.get(k-1);
    }
}  