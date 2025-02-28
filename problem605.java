import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.List;
import java.util.*;
import java.lang.*;

class problem605{
    public static void main(String args[]) throws IOException{  
        if (System.getProperty("ONLINE_JUDGE") == null) {
            // Redirecting the I/O to external files
 
            // as ONLINE_JUDGE constant is not defined which
            // means
 
            // the code is not running on an online judge
 
            PrintStream ps
                = new PrintStream(new File("output.txt"));
            InputStream is
                = new FileInputStream("input.txt");
 
            System.setIn(is);
            System.setOut(ps);
        }
        Scanner scan = new Scanner(System.in);
        //For reading string from input file
        //String myLine = scan.nextLine();
        //scan.nextLine();
        //To take int array as input

        int[] nums=new int[5];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }
        int n=scan.nextInt();
        boolean sol=canPlaceFlowers(nums, n);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  


    public static boolean canPlaceFlowers5(int[] flowerbed, int n) {
        if(n==0){
            return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i]==0 && (i==0 || flowerbed[i-1]==0) && (i==flowerbed.length-1||flowerbed[i+1]==0)){
                flowerbed[i]=1;
                n--;
            }
            if(n==0){
                return true;
            }
        }
        return false;
    }

    public static boolean canPlaceFlowers2(int[] flowerbed, int n) {
        if(n==0){
            return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i]==0 &&(i==0||flowerbed[i-1]==0 ) &&(i==flowerbed.length-1||flowerbed[i+1]==0)){
                flowerbed[i]=1;
                n--;
                if(n==0){
                    return true;
                }
            }
        }
        return false;
    }



    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length-1; i++) {
            if(i==0){
                if(flowerbed[i]==0 && flowerbed[i+1]==0){
                    flowerbed[0]=1;
                    n=n-1;
                }
            }
            else{
                if(flowerbed[i-1]==0 && flowerbed[i]==0 && flowerbed[i+1]==0){
                flowerbed[i]=1;
                n=n-1;
                }
            }
        }
        if(flowerbed[flowerbed.length-1]==0 && flowerbed[flowerbed.length-2]==0){
            n=n-1;
        }
        return n==0?true:false;
    }
}  
