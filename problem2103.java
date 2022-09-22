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

import javax.swing.colorchooser.ColorChooserComponentFactory;

import java.lang.*;

class problem2103{
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
        int sol=countPoints("G4");
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static int countPoints(String rings) {
        Map<Integer,List<String>> hMap=new HashMap<>();
        int solution=0;
        for (int i = 0; i < rings.length()-1; i=i+2) {
            Character c=rings.charAt(i);
            int value=Character.getNumericValue(rings.charAt(i+1));
            String s="";
            if(c=='R'){
                s="Red";
            }else if(c=='B'){
                s="Blue";
            }else{
                s="Green";
            }
            if(hMap.containsKey(value)){
                List<String> list=hMap.get(value);
                list.add(s);
                hMap.put(value, list);
            }else{
                List<String> newList=new ArrayList<>();
                newList.add(s);
                hMap.put(value, newList);
            }
        }
        for (Map.Entry<Integer,List<String>> hEntry : hMap.entrySet()) {
            List<String> currentString=hEntry.getValue();
            int countR=0;
            int countB=0;
            int countG=0;
            for (String string : currentString) {
                
                if(string.equals("Red")){
                    countR++;
                }else if(string.equals("Blue")){
                    countB++;
                }else{
                    countG++;
                }
            }
            if(countB>0 && countG>0 && countR>0){
                solution++;
            }
        }
        return solution;
    }
}  