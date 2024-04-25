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

class problem752{
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
    
    public int openLock(String[] deadends, String target) {
        Queue<String> q=new LinkedList<>();
        Set<String> deads=new HashSet<>(Arrays.asList(deadends));
        Set<String> visited=new HashSet<>();
        q.offer("0000");
        visited.add("0000");
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size>0){
                String s=q.poll();
                if(deads.contains(s)){
                    size--;
                    continue;
                }
                if(s.equals(target)){
                    return level;
                }
                StringBuilder sb=new StringBuilder(s);
                for (int i = 0; i < 4; i++) {
                    char c=sb.charAt(i);
                    String s1=sb.substring(0,i)+(c=='9'?0:c-'0'+1)+
                    sb.substring(i+1);

                    String s2=sb.substring(0,i)+(c=='0'?9:c-'0'+1)+
                    sb.substring(i+1);
                    if(!visited.contains(s1) &&!deads.contains(s1)){
                        q.offer(s1);
                        visited.add(s1);
                    }
                    if(!visited.contains(s2) &&!deads.contains(s2)){
                        q.offer(s2);
                        visited.add(s2);
                    }
                }
                size--;
            }
            level++;
        }
        return -1;

    }
}  