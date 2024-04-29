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

class problem140{
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
    
    class Trie{
        boolean isWord;
        String word;
        Trie[] next;
        Trie(){
            next=new Trie[26];
        }
    }

    Trie root=new Trie();

    public List<String> wordBreak(String s, List<String> wordDict) {
        for (String word : wordDict) {
            addWord(word,root);
        }
        List<String> res=new ArrayList<>();
        List<String> current=new ArrayList<>();
        dfs(s,0,root,current,res);
        return res;
    }

    public void dfs(String s,int index,Trie node,List<String> current,List<String> res){
        if(index==s.length()){
            if(node==root){
                res.add(String.join(" ",current));
            }
            return;
        }
        if(node==null){
            return;
        }
        Trie trie=node.next[s.charAt(index)-'a'];
        if(trie !=null && trie.isWord){
            current.add(trie.word);
                //current.add(trie.word);
                dfs(s,index+1,root,current,res);
                current.remove(current.size()-1);
        }
        dfs(s, index+1, trie, current, res);
    }

    public void addWord(String word,Trie dic){
        Trie ptr=root;
        for (int i = 0; i < word.length(); i++) {
            int idx=word.charAt(i)-'a';
            if(ptr.next[idx]==null){
                ptr.next[idx]=new Trie();
            }
            ptr=ptr.next[idx];
        }
        ptr.isWord=true;
        ptr.word=word;
    }
}  