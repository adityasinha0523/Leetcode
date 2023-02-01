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

class problem2446{
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
        String[] event1=new String[2];
        event1[0]="01:15";
        event1[1]="02:00";
        String[] event2=new String[2];
        event2[0]="02:00";
        event2[1]="03:00";
        boolean sol=haveConflict(event1, event2);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static boolean haveConflict(String[] event1, String[] event2) {
        String s1=event1[0];
        String[] S1arr=s1.split(":");
        int hourS1=Integer.parseInt(S1arr[0]);
        int minS1=Integer.parseInt(S1arr[1]);
        int startingValueS1=hourS1*60+minS1;
        String s2=event1[1];
        String[] S2arr=s2.split(":");
        int hourS2=Integer.parseInt(S2arr[0]);
        int minS2=Integer.parseInt(S2arr[1]);
        int endingValueS1=hourS2*60+minS2;
        String s3=event2[0];
        String[] S3arr=s3.split(":");
        int hourS3=Integer.parseInt(S3arr[0]);
        int minS3=Integer.parseInt(S3arr[1]);
        int startingValueS2=hourS3*60+minS3;
        String s4=event2[1];
        String[] S4arr=s4.split(":");
        int hourS4=Integer.parseInt(S4arr[0]);
        int minS4=Integer.parseInt(S4arr[1]);
        int endingValueS2=hourS4*60+minS4;
        int[] counter=new int[1501];
        int[] counter2=new int[1501];
        for (int i = startingValueS1; i <=endingValueS1; i++) {
            counter[i]=1;
        }
        for (int i = startingValueS2; i <=endingValueS2; i++) {
            counter2[i]=1;
        }
        for (int i = 0; i < counter2.length; i++) {
            if(counter[i]==1 && counter2[i]==1){
                return true;
            }
        }
        return false;
    }
}  
