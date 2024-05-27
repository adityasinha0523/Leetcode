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

class problem993{
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
    
    
    public static boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return false;
        }
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            Set<Integer> set=new HashSet<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp=q.poll();
                if(temp.left!=null){
                    if(temp.right!=null){
                        if(temp.left.val==x && temp.right.val==y){
                            return false;
                        }else{
                            q.add(temp.left);
                            set.add(temp.left.val);
                        }
                    }else{
                        q.add(temp.left);
                        set.add(temp.left.val);
                    }
                    if(temp.left.val==x &&set.contains(y)){
                        return true;
                    }
                }
                if(temp.right!=null){
                    q.add(temp.right);
                    set.add(temp.right.val);
                    if(temp.right.val==y &&set.contains(x)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}  