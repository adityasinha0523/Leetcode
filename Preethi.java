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
import java.io.StreamCorruptedException;
import java.util.*;
import java.lang.*;

class Preethi{
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
        
        //1D Array
        /*int[] nums=new int[3];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/

        //Taking 2D Array as input
        /*int[][] nums=new int[3][3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                nums[i][j]=scan.nextInt();
            }
        }*/
        //Taking String as input.
        //String s=scan.nextLine();

        //String xValue=Integer.toBinaryString(5);
        //Printing 1D Array.
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        /*for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.println( sol[i][j]);
            }
        }*/
        //System.out.println(sol);
        //String sol=replaceString("This is the val_uee ___newNumber ___secret_fun___");
        //String sol=replaceString("This is the doc_stri_ng __for __secret_fun___");
        String sol=replaceString("anotherVariable__");
        System.out.println(sol);
        scan.close();
    } 
    
    public static String replaceString(String src){
        StringBuilder sb=new StringBuilder();
        String[] strArr=src.split(" ");
        for (int i = 0; i < strArr.length; i++) {
            String s=strArr[i];
            boolean foundChar=false;
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j)=='_' && foundChar){
                    int count=0;
                    while(j<s.length() && s.charAt(j)=='_'){
                        count++;
                        j++;
                    }
                    if(j==s.length()){  
                        while(count!=0){
                            sb.append("_");
                            count--;
                        }
                    }else{
                        sb.append(Character.toUpperCase(s.charAt(j)));
                    }
                    
                }else{
                    if(s.charAt(j)=='_'){
                        sb.append(s.charAt(j));
                    }
                    else{
                        sb.append(s.charAt(j));
                        foundChar=true;
                    }
                    
                }
            }
            if(i!=strArr.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}  