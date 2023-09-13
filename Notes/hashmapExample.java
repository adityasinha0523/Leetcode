package Notes;
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

class hashmapExample{
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
        HashMap<String,List<String>> map=new HashMap<>();
        List<String> a=new ArrayList<>();
        a.add("xyz");
        
        List<String> e=new ArrayList<>();
        a.add("qwe");
        List<String> b=new ArrayList<>();
        a.add("adsadasd");
        List<String> c=new ArrayList<>();
        a.add("xcvxcv");
        List<String> d=new ArrayList<>();
        a.add("dasdqwe");
        map.put("abc",a);
        for (Map.Entry<String,List<String>> hEntry : map.entrySet()) {
            String key=hEntry.getKey();
                List<String> value=hEntry.getValue();
                for (int i = 0; i < value.size(); i++) {
					System.out.println("Key is "+key);
					System.out.println("Valus is "+value.get(i));
			}
        }
        scan.close();
    }  

}  