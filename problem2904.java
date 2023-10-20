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

class problem2904{
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

        String s="001";
        int k=1;
        String sol=shortestBeautifulSubstring(s, k);
        //Printing 1D Array.
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static String shortestBeautifulSubstring(String s, int k) {
        String solution="";
        boolean found=false;
        for (int i = 0; i < s.length()-1; i++) {
            int counter=0;
            int initialIndex=0;
            for (int j = i; j < s.length(); j++) {
                if(s.charAt(j)=='1'){
                    if(counter==0){
                        initialIndex=j;
                    }
                    counter++;
                }
                if(counter==k){
                    String tempString=s.substring(initialIndex, j+1);
                    if(tempString.length()<solution.length() &&found==true){
                        solution=tempString;
                    }
                    else if(tempString.length()==solution.length() &&found==true){
                        if(tempString.compareTo(solution)<0){
                            solution=tempString;
                        }
                    }
                    else if(found==false){
                        solution=tempString;
                        found=true;
                    }
                }
            }
        }
        return solution;
    }
}  