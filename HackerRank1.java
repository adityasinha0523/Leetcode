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

class HackerRank1{
    public static void main(String args[]) throws IOException{  
        Scanner scan = new Scanner(System.in);
        //For reading string from input file
        //String myLine = scan.nextLine();
        //scan.nextLine();
        //To take int array as input
        int t=scan.nextInt();
        int[] arr=new int[t];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=scan.nextInt();
        }
        Arrays.sort(arr);
        if(arr.length<4){
            System.out.println("-1");
        }else{
            Map<Integer,Integer> map=new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            }
            
        }
        
        scan.close();
    }  

}  