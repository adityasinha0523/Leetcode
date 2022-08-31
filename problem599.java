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

class problem599{
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

        
        String[] list1=new String[3];
        for (int i = 0; i < list1.length; i++) {
            list1[i]=scan.nextLine();
        }
        String[] list2=new String[3];
        for (int i = 0; i < list2.length; i++) {
            list2[i]=scan.nextLine();
        }
        String[] sol=findRestaurant(list1, list2);
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
        scan.close();
    }  

    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> hMap=new HashMap<>();
        List<String> res=new LinkedList<>();
        int minIndex=Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            hMap.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if(hMap.containsKey(list2[i])){
                int value=hMap.get(list2[i])+i;
                if(value==minIndex){
                    res.add(list2[i]);
                }
                if(value<minIndex){
                    res.clear();
                    res.add(list2[i]);
                    minIndex=value;
                }
            }
        }
        String[] sol=new String[res.size()];
        String[] newString=res.toArray(sol);
        return sol;
    }
}  