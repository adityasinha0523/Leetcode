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

class problem433{
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

    public static int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)){
            return 0;
        }
        char[] charSet=new char[]{'C','G','A','T'};
        Set<String> visited=new HashSet<>();
        Queue<String> queue=new LinkedList<>();
        queue.add(start);
        visited.add(start);
        int level=0;
        Set<String> banks=new HashSet<>();
        for (int i = 0; i < bank.length; i++) {
            banks.add(bank[i]);
        }
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size!=0){
                String current=queue.poll();
                if(current.equals(end)){
                    return level;
                }
                char[] charArr=current.toCharArray();
                for (int i = 0; i < charArr.length; i++) {
                    char old=charArr[i];
                    for (char c : charArr) {
                        charArr[i]=c;
                        String newString=new String(charArr);
                        if(!visited.contains(newString)&& banks.contains(newString)){
                            visited.add(newString);
                            queue.add(newString);
                        }
                    }
                    charArr[i]=old;    
                }
                size--;
            }
            level++;
        }
        return -1;
    }
}  