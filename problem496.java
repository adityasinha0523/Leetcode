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

class problem496{
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

        /*int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/
        int[] nums1=new int[3];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i]=scan.nextInt();
        }
        int[] nums2=new int[4];
        for (int i = 0; i < nums2.length; i++) {
            nums2[i]=scan.nextInt();
        }
        int[] sol=nextGreaterElement2(nums1, nums2);
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
        //System.out.println(sol);
        scan.close();
    }  

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] solution=new int[nums1.length];
        int k=0;
        for (int i = 0; i < nums1.length; i++) {
            int findValue=nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                if(nums2[j]==findValue){
                    boolean found=false;
                    while(j<nums2.length){
                        if(nums2[j]>findValue){
                            found=true;
                            solution[k++]=nums2[j];
                            break;
                        }
                        j++;
                    }
                    if(found==false){
                        solution[k++]=-1;
                    }
                }
            }
        }
        return solution;
    }

    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();
        Map<Integer,Integer> map=new HashMap<>();
        stack.add(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            while(stack.size()>0 && nums2[i]>stack.peek()){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while(!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }
        int[] solution=new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            solution[i]=map.get(nums1[i]);
        }
        return solution;
    }
}  
