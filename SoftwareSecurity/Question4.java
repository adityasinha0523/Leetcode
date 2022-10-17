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

public class Question4 {
    public static void main(String args[]) {
      List<String> list1 = new ArrayList<String>();

        for (char c1 ='a'; c1<='z'; c1++){
        for(char c2 ='a'; c2<='z'; c2++){
          for(char c3 ='a'; c3<='z'; c3++)
           {
            StringBuilder sb=new StringBuilder();
            
            sb.append(c1);
            sb.append(c2);
           sb.append(c3);  
            list1.add(sb.toString()); 
            
            }
        }
      }
       System.out.println(list1);
    }
}