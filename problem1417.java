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

class problem1417{
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

    public static String reformat(String s) {
        List<Integer> listInt=new ArrayList<>();
        List<Character> listChar=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))){
                listInt.add(Character.getNumericValue(s.charAt(i)));
            }else{
                listChar.add(s.charAt(i));
            }
        }
        if(Math.abs(listChar.size()-listInt.size())<2){
            int charIndex=0;
            int intIndex=0;
            if(listChar.size()>listInt.size()){
                sb.append(listChar.get(charIndex++));
            }else if(listChar.size()<listInt.size()){
                sb.append(listInt.get(intIndex++));
            }
            while(charIndex<listChar.size()){
                sb.append(listChar.get(charIndex++));
                sb.append(listInt.get(charIndex++));
            }
        }else{
            return "";
        }
        return sb.toString();
    }
}  