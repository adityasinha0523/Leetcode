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

class hackerrank3{
    public static void main(String args[]) throws IOException{  
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        Map<String,Integer> map=new HashMap<>();
		while (T-- > 0) {
            //in.nextLine();
            String intputString=in.nextLine();
            //System.out.println("Value of input string "+intputString);
            String[] arrString=intputString.split(" ");
            String first=arrString[0];
            String second=arrString[1];
            StringBuilder sb=new StringBuilder();
            
            sb.append(first.charAt(0));
            sb.append(second.charAt(0));
            if(second.length()>=2){
                sb.append(second.charAt(1));
            }
            if(second.length()>=3){
                sb.append(second.charAt(2));
            }
            if(second.length()>=4){
                sb.append(second.charAt(3));
            }
            String s=sb.toString();
            if(map.containsKey(s)){
                int value=map.get(s);
                sb.append(value+1);
                map.put(s,value+1);
                System.out.println(sb.toString());
            }else{
                System.out.println(s);
                map.put(s,0);
            }
        }    
        in.close();
    }
}  
