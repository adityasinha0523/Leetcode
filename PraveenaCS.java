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

class PraveenaCS{
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
        
        String[] nums=new String[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextLine();
        }
        String time="14:00";
        int sol=solution(nums,time );
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int solution(String[] schedule,String time){
        int[] value=new int[schedule.length];
        for(int i=0;i<schedule.length;i++){
            String[] s=schedule[i].split(":");
            int hour=Integer.valueOf(s[0]);
            int minute=Integer.valueOf(s[1]);
            int totalValue=hour*60+minute;
            value[i]=totalValue;
        }
        String[] strArr=time.split(":");
        int hour=Integer.valueOf(strArr[0]);
        int minute=Integer.valueOf(strArr[1]);
        int totalValue=hour*60+minute;
        int minDiff=Integer.MAX_VALUE;
        for (int i = 0; i < value.length; i++) {
            if(totalValue==value[i]){
                if(i==0){
                    return -1;
                }else{
                    int prevVal=totalValue-value[i-1];
                    return prevVal;
                }
            }else if(value[i]<totalValue){
                if(totalValue-value[i]<minDiff){
                    minDiff=totalValue-value[i];
                }
                
            }
        }
        if(minDiff==Integer.MAX_VALUE){
            return -1;
        }
        return minDiff;
    }
}  