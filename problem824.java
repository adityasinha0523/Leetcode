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

class problem824{
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
        String sol=toGoatLatin("I speak Goat Latin");
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static String toGoatLatin(String sentence) {
        Set<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        char k=' ';
        char a='a';
        int counter=1;
        String[] strArr=sentence.split(" ");
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            String s=strArr[i];
            boolean isConstant=false;
            for (int j = 0; j < s.length(); j++) {
                char c=s.charAt(j);
                if(j==0){
                    if(set.contains(c)){
                        sb.append(c);
                    }else{
                        k=c;
                        isConstant=true;
                    }
                }else{
                    sb.append(c);
                }
            }
            if(isConstant==true){
                sb.append(k);
            }
            sb.append("ma");
            for (int j = 0; j < counter; j++) {
                sb.append(a);
            }
            if(i!=strArr.length-1){
                sb.append(" ");
            }
            counter++;
        }
        return sb.toString();
    }
}  