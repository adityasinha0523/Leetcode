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

import problem208.TrieNode;

import java.lang.*;

class problem421{
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
    


    public int findMaximumXOR(int[] nums) {
        TrieNode root=new TrieNode();
        int maxXor=Integer.MIN_VALUE;
        for (int num : nums) {
            insert(root ,num);
        }
        for (int num : nums) {
            maxXor=Math.max(maxXor, getMaxXor(root,num));
        }
        return maxXor;
    }

    class TrieNode{
        TrieNode left,right;
        public TrieNode(){
            left=null;
            right=null;
        }
    }

    public void insert(TrieNode root,int num){
        TrieNode curr=root;
        for (int i = 31; i >=0; i--) {
            int bit=(num>>i) & 1;
            if(bit==0){
                if(curr.left==null){
                    curr.left=new TrieNode();
                }
                curr=curr.left;
            }else{
                if(curr.right==null){
                    curr.right=new TrieNode();
                }
                curr=curr.right;
            }
        }
    }

    public int getMaxXor(TrieNode root,int num){
        TrieNode curr=root;
        int maxXor=0;

        for (int i = 31; i >=0; i--) {
            int bit=(num>>i) &1;
            if(bit==0){
                if(curr.right!=null){
                    curr=curr.right;
                    maxXor+=(1<<i);
                }else{
                    curr=curr.left;
                }
            }else{
                if(curr.left!=null){
                    curr=curr.left;
                    maxXor+=(1<<i);
                }else{
                    curr=curr.right;
                }
            }
        }
        return maxXor;
    }
}  