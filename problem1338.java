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
import java.util.*;
import java.lang.*;

class problem1338{
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
        //For reading integer from input file
        //int a=scan.nextInt();
        //String temp1="leetcodeisacommunityforcoders";
        //int temp2=4;
        /*int [] input=new int[4];
        for (int i = 0; i < input.length; i++) {
            input[i]=scan.nextInt();
        }*/
        int[] num=new int[10];
        for (int i = 0; i < num.length; i++) {
            num[i]=scan.nextInt();
        }
        int sol=minSetSize(num);
        
        System.out.println(sol);
        scan.close();
    }  

    /*public static int minSetSize(int[] arr) {
        
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int x : arr) cnt.put(x, cnt.getOrDefault(x, 0) + 1);

        int n=cnt.values().size();
        int[] frequencies = new int[n];
        int i = 0;
        for (int freq : cnt.values()) frequencies[i++] = freq;
        Arrays.sort(frequencies);

        int ans = 0, removed = 0, half = arr.length / 2;
        i = frequencies.length - 1;
        while (removed < half) {
            ans += 1;
            removed += frequencies[i--];
        }
        return ans;
    }*/

    public static int minSetSize(int[] arr) {
        Map<Integer,Integer> hMap=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hMap.put(arr[i], hMap.getOrDefault(arr[i], 0)+1);
        }
        int frequencies[] =new int[hMap.values().size()];
        int k=0;
        for (int i : hMap.values()) {
            frequencies[k++]=i;
        }
        Arrays.sort(frequencies);
        int half=arr.length/2;
        int ans=0;
        int p=frequencies.length-1;
        int currentVal=0;
        while(currentVal<half){
            ans=ans+1;
            currentVal+=frequencies[p--];
        }
        return ans;
    }
}  