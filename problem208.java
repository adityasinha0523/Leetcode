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

class problem208{
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
    
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        public TrieNode(){
            isEnd=true;
            children=new TrieNode[26];
        }
    }

    public class Trie{
        private TrieNode root;
        public Trie(){
            root=new TrieNode();
        }
        
        public void insert(String word){
            TrieNode current=root;
            for (int i = 0; i < word.length(); i++) {
                int id=word.charAt(i)-'a';
                if(current.children[id]==null){
                    current.children[id]=new TrieNode();
                    current.children[id].isEnd=false;
                }
                current=current.children[id];
            }
            current.isEnd=true;
        }
        public boolean search(String word){
            return search(word,1);
        }
        public boolean startsWith(String prefix){
            return search(prefix,2);
        }

        public boolean search(String str,int type){
            TrieNode current=root;
            int i=-1,L=str.length();
            while(++i<L){
                int id=str.charAt(i)-'a';
                if((current=current.children[id])==null){
                    return false;
                }
            }
            return type==1?current.isEnd:true;
        }
    }
}  