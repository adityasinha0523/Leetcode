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

class problem151{
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
        
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static String reverseWords(String s) {
        char[] ch=s.toCharArray();
        List<String> s1=new ArrayList<>();
        StringBuilder ss=new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if(ch[i]==' '){
                if(ss.length()>0){
                    s1.add(ss.toString());
                    ss=new StringBuilder();
                }
                //ss.trimToSize();
            }else{
                ss.append(ch[i]);
            }
        }
        if(ss.length()>0){
            s1.add(ss.toString());
        }
        String[] sArr=new String[s1.size()];
        for (int i = 0; i < s1.size(); i++) {
            sArr[i]=s1.get(i);
        }
        int last=sArr.length-1;
        StringBuilder sb=new StringBuilder();
        while(last>0){
            sb.append(sArr[last]);
            sb.append(" ");
            last--;
        }
        sb.append(sArr[last]);
        return sb.toString();
    }
}  
