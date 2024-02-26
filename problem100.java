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

class problem100{
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

    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        ans=true;
        helper(p,q);
        return ans;
    }
    
    public void helper(TreeNode p,TreeNode q){
        if(p!=null && q!=null){
            if( p.val==q.val){
                helper(p.left,q.left);
                helper(p.right,q.right);
            }else{
                ans=false;
            }
        }else if(p==null &&q!=null){
            ans=false;
        }else if(q==null && p!=null){
            ans=false;
        }
    }
    }
    boolean answer=true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        helper(p,q);
        return answer;
    }

    public void helper(TreeNode p,TreeNode q){
        if(p!=null && q!=null){
            if(p.val!=q.val){
                ans=false;
            }else{
                helper(p.left,q.left);
                helper(p.right,q.right);
            }
        }
        else if(p==null &&q!=null){
            answer=false;
        }else if(p!=null && q==null){
            answer=false;
        }
    }
}  