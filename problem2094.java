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

class problem2094{
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
        //System.out.println(sol);
        scan.close();
    }  

    public static int[] findEvenNumbers(int[] digits) {
        int[] map=new int[10];
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < digits.length; i++) {
            map[digits[i]]++;
        }
        for (int i = 100; i <=999; i=i+2) {
            int num=i;
            int[] temp=new int[10];
            while(num!=0){
                int val=num%10;
                temp[val]++;
                num=num/10;
            }
            boolean res=helper(temp,map);
            if(res){
                list.add(i);
            }
            
        }
        int[] sol=new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            sol[j]=list.get(j);
        }
        return sol;
    }

    public static boolean helper(int [] num,int[] map){
        for (int i = 0; i < 10; i++) {
            if(num[i]>map[i]){
                return false;
            }
        }
        return true;
    }
}  