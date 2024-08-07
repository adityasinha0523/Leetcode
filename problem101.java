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

class problem101{
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
        
        /*int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/
        
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return true;
        }
        List<TreeNode> list=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp=q.poll();
                if(temp.left==null){
                    list.add(null);
                }
                if(temp.left!=null){
                    q.add(temp.left);
                    list.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                    list.add(temp.right);
                }
                if(temp.right==null){
                    list.add(null);
                }
            }
            if(checkSymmetric(list)==false){
                return false;
            }
        }
        return true;
    }

    public boolean checkSymmetric(List<TreeNode> list){
        int start=0;
        int end=list.size()-1;
        while(start<end){
            TreeNode temp1=list.get(start);
            TreeNode temp2=list.get(end);
            if(temp1==null && temp2!=null){
                return false;
            }else if(temp1 !=null && temp2==null){
                return false;
            }else if(temp1==null && temp2==null){
                start++;
                end--;
                continue;
            }
            
            else if(temp1.val!=temp2.val){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}  