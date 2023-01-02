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

class problem422{
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
        List<String> input=new ArrayList<>();
        input.add("abcd");
        input.add("bnrt");
        input.add("crm");
        input.add("dt");
        boolean sol=validWordSquare(input);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  

    public static boolean validWordSquare(List<String> words) {
        int maxLength=0;
        for (String string : words) {
            int length=string.length();
            maxLength=Math.max(maxLength, length);
        }
        Character[][] stringArr=new Character[words.size()][maxLength];
        int row=0;
        int col=0;
        for (int i = 0; i < words.size(); i++) {
            String s=words.get(i);
            col=0;
            for (int j = 0; j < s.length(); j++) {
                stringArr[row][col++]=s.charAt(j);
            }
            row++;
        }
        List<String> rowString=new ArrayList<>();
        for (int i = 0; i < stringArr.length; i++) {
            StringBuilder sb=new StringBuilder();
            for (int j = 0; j < stringArr[0].length; j++) {
                sb.append(stringArr[i][j]);
            }
            rowString.add(sb.toString());
        }
        List<String> colString=new ArrayList<>();
        for (int i = 0; i < stringArr[0].length; i++) {
            StringBuilder sb=new StringBuilder();
            for (int j = 0; j < stringArr.length; j++) {
                sb.append(stringArr[j][i]);
            }
            colString.add(sb.toString());
        }
        for (int i = 0; i < rowString.size(); i++) {
            String first=rowString.get(i);
            String second=colString.get(i);
            if(!first.equals(second)){
                return false;
            }
        }
        return true;
    }
}  