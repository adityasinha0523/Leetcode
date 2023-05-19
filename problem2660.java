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

class problem2660{
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
        
        int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        int[] nums2=new int[4];
        for (int i = 0; i < nums2.length; i++) {
            nums2[i]=scan.nextInt();
        }
        int sol=isWinner(nums, nums2);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int isWinner(int[] player1, int[] player2) {
        int sol1=0;
        int sol2=0;
        boolean foundten1=false;
        int count1=2;
        for (int i = 0; i < player1.length; i++) {
            int value=player1[i];
            if(foundten1==true){
                if(value==10){
                    sol1+=count1<=0?value:value*2;
                    count1=2;
                }
                else{
                    if(count1>0){
                        sol1+=value*2;
                        count1=count1-1;
                    }else{
                        sol1+=value;
                        foundten1=false;
                    }
                }
            }else{
                if(value==10){
                    foundten1=true;
                    count1=2;
                    sol1+=value;
                }else{
                    sol1+=value;
                }
            }
        }
        System.out.println("Value of 1st "+sol1);
        boolean foundten2=false;
        int count2=2;
        for (int i = 0; i < player2.length; i++) {
            int value=player2[i];
            if(foundten2==true){
                if(value==10){
                    sol2+=count2<=0?value:value*2;
                    count2=2;
                }else{  
                    if(count2>0){
                        sol2+=value*2;
                        count2=count2-1;
                    }else{
                        sol2+=value;
                        foundten2=false;
                    }
                }
            }else{
                if(value==10){
                    foundten2=true;
                    count2=2;
                    sol2+=value;
                }else{
                    sol2+=value;
                }
            }
        }
        System.out.println("Value of 2nd "+sol2);
        if(sol1>sol2){
            return 1;
        }else if(sol2>sol1){
            return 2;
        }
        return 0;
    }
}  