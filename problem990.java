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

class problem990{
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
    int[] parent = new int[26];
    //size is used to make the tree degree lower
    int[] rank = new int[26];
    public boolean equationsPossible(String[] equations) {
        for(int i = 0; i < 26; i++){
            rank[i] = 1;
            parent[i] = i;
        }
        for(String s: equations){
            if(s.charAt(1) == '='){
                int a = s.charAt(0) - 'a';
                int b = s.charAt(3) - 'a';
                unionByRank(a, b);
            }
        }
        for(String s : equations){
            if(s.charAt(1) == '!'){
                int a = s.charAt(0) - 'a';
                int b = s.charAt(3) - 'a';
                int valA=find(a);
                int valB=find(b);
                if(valA==valB) return false;
            }
        }
        return true;
    }
    public boolean equationsPossible2(String[] equations) {
        for (int i = 0; i < 26; i++) {
            parent[i]=parent[i];
            rank[i]=1;

            for (String string : equations) {
                if(string.charAt(1)=='='){
                    int a=string.charAt(0)-'a';
                    int b=string.charAt(3)-'a';
                    unionByRank(a, b);
                }
            }
            for (String string : equations) {
                if(string.charAt(1)=='!'){
                    int a=string.charAt(0)-'a';
                    int b=string.charAt(3)-'a';
                    int valA=find(a);
                    int valB=find(b);
                    if(valA==valB){
                        return true;
                    }
                    //unionByRank(a, b);
                }
            }
        }
        return false;
    }    
    public int find(int i)
	{
		if (parent[i] != i) {
			parent[i] = find(parent[i]); // Path compression
		}
		return parent[i];
	}

	// Unites the set that includes i and the set that
	// includes j by rank
	public void unionByRank(int i, int j){
		// Find the representatives (or the root nodes) for
		// the set that includes i and j
		int irep = find(i);
		int jrep = find(j);

		// Elements are in the same set, no need to unite
		// anything
		if (irep == jrep) {
			return;
		}

		// Get the rank of i's tree
		int irank = rank[irep];

		// Get the rank of j's tree
		int jrank = rank[jrep];

		// If i's rank is less than j's rank
		if (irank < jrank) {
			// Move i under j
			parent[irep] = jrep;
		}
		// Else if j's rank is less than i's rank
		else if (jrank < irank) {
			// Move j under i
			parent[jrep] = irep;
		}
		// Else if their ranks are the same
		else {
			// Move i under j (doesn't matter which one goes
			// where)
			parent[irep] = jrep;
			// Increment the result tree's rank by 1
			rank[jrep]++;
		}
	}
}  
