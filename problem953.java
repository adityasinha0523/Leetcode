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

class problem953{
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
        String[] nums=new String[2];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextLine();
        }
        String order=scan.nextLine();
        boolean sol=isAlienSorted(nums, order);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            String first=words[i-1];
            String second=words[i];
            int firstLen=first.length();
            int secondLen=second.length();
            int firstIndex=0;
            int secondIndex=0;
            boolean flag=false;
            while(firstIndex<firstLen && secondIndex<secondLen){
                int keyFirst=map.get(first.charAt(firstIndex++));
                int keySecond=map.get(second.charAt(secondIndex++));
                if(keySecond<keyFirst){
                    return false;
                }
                else if(keySecond==keyFirst){
                    continue;
                }else{
                    flag=true;
                    break; 
                }
            }
            if(!flag &&firstLen>secondLen){
                return false;
            }
        }
        return true;
    }
}  