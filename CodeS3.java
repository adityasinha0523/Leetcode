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

class CodeS3{
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
        List<String> words=new ArrayList<>();
        words.add("Co");
        words.add("Code");
        words.add("codesi");
        words.add("cosign");
        words.add("codesignal");

        String[] word=new String[5];
        word[0]="co";
        word[1]="code";
        word[2]="codesi";
        word[3]="codesign";
        word[4]="codesignal";
        int sol=checkAnswer(word);
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        System.out.println(sol);
        scan.close();
    }  
    
    public static int checkAnswer(String[] words){
        int solution=0;
        for (int i = 0; i < words.length-1; i++) {
            String first=words[i];
            for (int j = i+1; j < words.length; j++) {
                int firstLastIndex=words[i].length()-1;
                int secondLastIndex=words[j].length()-1;
                if(firstLastIndex<secondLastIndex){
                    secondLastIndex=firstLastIndex;
                }else{
                    firstLastIndex=secondLastIndex;
                }
                String second=words[j];
                int firstIndex=0;
                int secondIndex=0;
                boolean foundMismatch=false;
                while(firstIndex<firstLastIndex && secondIndex<secondLastIndex){
                    if(first.charAt(firstIndex)!=second.charAt(secondIndex)||first.charAt(firstLastIndex)!=second.charAt(secondLastIndex)){
                        foundMismatch=true;
                        break;
                    }
                    firstIndex++;
                    secondIndex++;
                    firstLastIndex--;
                    secondLastIndex--;
                }
                if(foundMismatch==false){
                    solution++;
                }

            }
        }
        return solution;
    }

    public static int countPrefixes(List<String> words) {
        HashMap<String, Integer> prefixes = new HashMap<String, Integer>();
        int count = 0;

        for (String word : words) {
            for (int i = 1; i <= word.length(); i++) {
                String prefix = word.substring(0, i);
                if (prefixes.containsKey(prefix)) {
                    count++;
                } else {
                    prefixes.put(prefix, 1);
                }
            }
        }

        return count;
    }
}  