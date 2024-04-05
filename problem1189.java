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

class problem1189{
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
        int sol=maxNumberOfBalloons("leetcode");
        /*for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }*/
        System.out.println(sol);
        scan.close();
    }
    
    public static int maxNumberOfBalloons2(String text) {
        int solution=Integer.MAX_VALUE;
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0)+1);
        }
        if(map.containsKey('b')){
            solution=Math.min(solution, map.get('b'));
        }
        else{
            return 0;
        }
        if(map.containsKey('a')){
            solution=Math.min(solution, map.get('a'));
        }
        else{
            return 0;
        }
        if(map.containsKey('l')){
            solution=Math.min(solution, map.get('l')/2);
        }
        else{
            return 0;
        }
        if(map.containsKey('o')){
            solution=Math.min(solution, map.get('o')/2);
        }
        else{
            return 0;
        }
        if(map.containsKey('n')){
            solution=Math.min(solution, map.get('n'));
        }
        else{
            return 0;
        }
        return solution;
    }


    public static int maxNumberOfBalloons(String text) {
        int[] arr=new int[26];
        for (int i = 0; i < text.length(); i++) {
            Character c=text.charAt(i);
            arr[c-'a']++;
        }
        int solution=0;
        solution=Math.min(arr[0], arr[1]);
        solution=Math.min(solution, arr[11]/2);
        solution=Math.min(solution, arr[14]/2);
        solution=Math.min(solution, arr[13]);
        return solution;
    }
}  