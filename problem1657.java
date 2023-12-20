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

class problem1657{
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
        

        boolean sol=closeStrings("abc", "bca");
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

    public static boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()){
            return false;
        }
        int[] list1=new int[26];
        int[] list2=new int[26];
        for (int i = 0; i < 26; i++) {
            list1[i]=0;
            list2[i]=0;
        }
        for (int i = 0; i < word1.length(); i++) {
            int val=word1.charAt(i)-'a';
            int curr=list1[val];
            //curr=curr;
            list1[val]=curr+1;
            val=word2.charAt(i)-'a';
            curr=list2[val];
            list2[val]=curr+1;
        }
        for (int i = 0; i < 26; i++) {
            if(list1[i]!=0 && list2[i]!=0){
                continue;
            }
            if(list1[i]==0 && list2[i]==0){
                continue;
            }
            return false;
        }
        Arrays.sort(list1);
        Arrays.sort(list2);
        for (int i = 0; i < 26; i++) {
            if(list1[i]!=list2[i]){
                return false;
            }
        }
        return true;
    }
}  
