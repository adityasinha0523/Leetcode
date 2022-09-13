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
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.*;
import java.util.*;

class problemArraylist{
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

        
        //scan.nextLine();
        //To take array as input
        int[] num=new int[4];
        for (int i = 0; i < num.length; i++) {
            num[i]=scan.nextInt();
        }
        int target=scan.nextInt();
        List<Integer> solution=targetIndices(num,target);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        for (Integer integer : solution) {
            System.out.println(integer);
        }

        Integer[] array = {1,2,3};
        List<Integer> list = Arrays.asList(array);
        array[1] = 10;
        System.out.println(list); // Prints [1, 10, 3]

        Integer[] array1 = {1,2,3};
        //Part of java 9
        //List<Integer> list1 = List.of(array1);
        //array1[1] = 10;
        //System.out.println(list1); // Prints [1, 2, 3]
        //System.out.println(sol);
        scan.close();
    }  

    public static List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target){
                list.add(i);
            }
        }
        return list;
    }
}  