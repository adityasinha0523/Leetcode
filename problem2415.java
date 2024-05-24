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

import java.lang.*;

class problem2415{
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
        //System.out.println(sol);
        scan.close();
    } 
    
    public static TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return null;
        }
        TreeNode tempVal=root;
        q.add(root);
        int count=0;
        while(!q.isEmpty()){
            int size=q.size();
            TreeNode arr[]=new TreeNode[size];
            for (int i = 0; i < size; i++) {
                arr[i]=q.poll();
                if(arr[i].left!=null){
                    q.add(arr[i].left);
                }
                if(arr[i].right!=null){
                    q.add(arr[i].right);
                }
            }
            count++;
            if(count%2!=0){
                reverse(arr);
            }
        }
        return tempVal;
    }

    public void reverse(TreeNode[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            TreeNode temp=arr[start];
            arr[start].val=arr[end].val;
            arr[end].val=temp.val;
            start++;
            end--;
        }
    }
}  