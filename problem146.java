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

class problem246{
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

    public static boolean isStrobogrammatic(String num) {
        //1,6,9,8,0
        int start=0;
        Set<Integer> set=new HashSet<>();
        set.add(1);
        set.add(6);
        set.add(9);
        set.add(8);
        set.add(0);
        int end=num.length()-1;
        while(start<=end){
            int val1=Character.getNumericValue(num.charAt(start));
            int val2=Character.getNumericValue(num.charAt(end));
            if(!set.contains(val1)||!set.contains(val2)){
                return false;
            }
            if(val1==1){
                if(val2!=1){
                    return false;
                }
            }
            if(val1==6){
                if(val2!=9){
                    return false;
                }
            }
            if(val1==9){
                if(val2!=6){
                    return false;
                }
            }
            if(val1==8){
                if(val2!=8){
                    return false;
                }
            }
            if(val1==0){
                if(val2!=0){
                    return false;
                }
            }
            start++;
            end--;
        }
        return true;
    }
}  