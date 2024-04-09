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

class problem28{
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
        //"mississippi"


        int sol=strStr("mississippi", "issip");
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
    
    public static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if(needle.charAt(0)==haystack.charAt(i)){
                int start=0;
                //int j=0;
                int hayStart=i;
                if((haystack.length()-hayStart)<needle.length()){
                    continue;
                }
                int temp=start;
                while(start<needle.length()){
                    if(needle.charAt(start)!=haystack.charAt(hayStart)){
                        break;
                    }
                    start++;
                    hayStart++;
                }
                if(start==needle.length()){
                    return temp;
                }
            }
        }
        return -1;
    }

    public static int strStr(String haystack, String needle) {
        int start=0;
        int end=haystack.length();
        while(start<end){
            if(haystack.charAt(start)==needle.charAt(0)){
                int needleStart=0;
                int needleEnd=needle.length();
                boolean notFound=false;
                int firstVal=start;
                while(start<end && needleStart<needleEnd){
                    if(haystack.charAt(start)!=needle.charAt(needleStart)){
                        notFound=true;
                    }
                    start++;
                    needleStart++;
                }
                if(needleStart==needleEnd && notFound==false){
                    return firstVal;
                }
                else{
                    start=firstVal;
                }
            }
            start++;
        }
        return -1;
    }
}  
