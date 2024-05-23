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

class problem2115{
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

    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> solution=new ArrayList<>();
        List<String> sup=new ArrayList<>();
        int[] indegree=new int[recipes.length];
        Map<String,Integer> index=new HashMap<>();
        Map<String,List<String>> ing=new HashMap<>();
        for (int i = 0; i < supplies.length; i++) {
            sup.add(supplies[i]);
        }
        for (int i = 0; i < recipes.length; i++) {
            index.put(recipes[i], i);
        }
        for (int i = 0; i < recipes.length; i++) {
            for (String str : ingredients.get(i)) {
                if(sup.contains(str)){
                    continue;
                }else{
                    ing.putIfAbsent(str, new ArrayList<String>());
                    //ing.put(str, recipes[i]);
                    ing.get(str).add(recipes[i]);
                    indegree[i]++;
                }
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int val=q.poll();
            solution.add(recipes[val]);
            if(!ing.containsKey(recipes[val])){
                continue;
            }else{
                List<String> str=ing.get(val);
                for(int i=0;i<str.size();i++){
                    indegree[index.get(str.get(i))]--;
                    if(indegree[index.get(str.get(i))]==0){
                        q.add(index.get(str.get(i)));
                    }
                }
                
            }
        }
        return solution;
    }
}  