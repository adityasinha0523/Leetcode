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

class problem859{
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

    public boolean buddyStrings(String s, String goal) {
        int counter=0;
        char firstSChar=' ';
        char secondSChar=' ';
        char firstGoalChar=' ';
        char secondGoalChar=' ';
        if(s.length()!=goal.length()){
            return false;
        }
        if(s.equals(goal)){
            int[] freq=new int[26];
            for(int i=0;i<s.length();i++){
                freq[s.charAt(i)-'a']++;
            }
            for(int i=0;i<freq.length;i++){
                if(freq[i]>1){
                    return true;
                }
            }
            return false;
        }
        if(s.length()==2){
            firstSChar=s.charAt(0);
            secondSChar=s.charAt(1);
            firstGoalChar=goal.charAt(0);
            secondGoalChar=goal.charAt(1);
            if(firstGoalChar==secondSChar && secondGoalChar==firstSChar){
                return true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=goal.charAt(i)){
                if(counter==0){
                    counter++;
                    firstGoalChar=goal.charAt(i);
                    firstSChar=s.charAt(i);
                }else if(counter==1){
                    counter++;
                    secondGoalChar=goal.charAt(i);
                    secondSChar=s.charAt(i);
                }else{
                    
                    return false;
                }
            }
        }
        if(counter==2 && firstGoalChar==secondSChar && secondGoalChar==firstSChar){
            return true;
        }
        return false;
    }
}  