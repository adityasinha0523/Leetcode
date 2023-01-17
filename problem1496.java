import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;
import java.lang.*;

class problem1496{
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
        boolean sol=isPathCrossing("NNSWWEWSSESSWENNW");
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static boolean isPathCrossing(String path) {
        int horizontal=0;
        int vertical=0;
        int x = 0, y = 0;
        Set<String> visited = new HashSet<String>();
        visited.add(x+","+y);
        for (int i = 0; i < path.length(); i++) {
            
                if(path.charAt(i)=='N'){
                    vertical++;
                }else if(path.charAt(i)=='S'){
                    vertical--;
                }else if(path.charAt(i)=='E'){
                    horizontal++;
                }else{
                    horizontal--;
                }
                String temp=vertical+","+horizontal;
            if(visited.contains(temp)){
                return true;
            }else{
                visited.add(temp);
            }
        }
        
        return false;
    }
}  