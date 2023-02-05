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

class problem2559{
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
        String[] word=new String[5];
        for (int i = 0; i < word.length; i++) {
            word[i]=scan.nextLine();
        }
        int[][] query=new int[3][2];
        for (int i = 0; i < query.length; i++) {
            for (int j = 0; j < query[0].length; j++) {
                query[i][j]=scan.nextInt();
            }
        }
        int[] sol=vowelStrings2(word,query);
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static int[] vowelStrings(String[] words, int[][] queries) {
        Map<String,Integer> map=new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char first=words[i].charAt(0);
            char last=words[i].charAt(words[i].length()-1);
            if(first=='a'||first=='e'||first=='i'||first=='o'||first=='u'){
                if(last=='a'||last=='e'||last=='i'||last=='o'||last=='u'){
                    map.put(words[i],i);
                }
            }
        }

        List<Integer> sol=new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int[] q=queries[i];
            int start=q[0];
            int end=q[1];
            int counter=0;
            for (int j = start; j <=end; j++) {
                if(map.containsValue(j)){
                    counter++;
                }
            }
            sol.add(counter);
        }
        int[] solution=new int[sol.size()];
        for (int i = 0; i < sol.size(); i++) {
            solution[i]=sol.get(i);
        }
        return solution;
    }

    public static int[] vowelStrings2(String[] words, int[][] queries) {
        int[] prefixSum=new int[100001];
        char first1=words[0].charAt(0);
        char last1=words[0].charAt(words[0].length()-1);
        if(first1=='a'||first1=='e'||first1=='i'||first1=='o'||first1=='u'){
            if(last1=='a'||last1=='e'||last1=='i'||last1=='o'||last1=='u'){
                prefixSum[0]=1;
            }else{
                prefixSum[0]=0;
            }
        }
        for (int i = 1; i < words.length; i++) {
            char first=words[i].charAt(0);
            char last=words[i].charAt(words[i].length()-1);
            if(first=='a'||first=='e'||first=='i'||first=='o'||first=='u'){
                if(last=='a'||last=='e'||last=='i'||last=='o'||last=='u'){
                prefixSum[i]=prefixSum[i-1]+1;
                }
                else{
                prefixSum[i]=prefixSum[i-1];
                }
            }else{
                prefixSum[i]=prefixSum[i-1];
            }
        }
        
        List<Integer> sol=new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int[] q=queries[i];
            int counter=0;
            int start=q[0];
            int end=q[1];
            if(start==0){
                if(prefixSum[0]==1){
                    counter=prefixSum[end]-prefixSum[start]+1;
                }else{
                    counter=prefixSum[end]-prefixSum[start];
                }
                
            }else{
                counter=prefixSum[end]-prefixSum[start-1];
            }   
            
            sol.add(counter);
        }
        int[] solution=new int[sol.size()];
        for (int i = 0; i < sol.size(); i++) {
            solution[i]=sol.get(i);
        }
        return solution;
    }
}  