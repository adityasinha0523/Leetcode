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
import java.util.Scanner;
import java.util.List;
import java.util.*;
import java.lang.*;

class problem2383{
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
        //For reading integer from input file
        //int a=scan.nextInt();
        //String temp1="leetcodeisacommunityforcoders";
        //int temp2=4;
        /*int [] input=new int[4];
        for (int i = 0; i < input.length; i++) {
            input[i]=scan.nextInt();
        }*/

        
        //scan.nextLine();
        //To take array as input
        int initialEnergy=scan.nextInt();
        int initialExperience=scan.nextInt();
        int[] energy=new int[1];
        for (int i = 0; i < energy.length; i++) {
            energy[i]=scan.nextInt();
        }
        int[] experience=new int[1];
        for (int i = 0; i < experience.length; i++) {
            experience[i]=scan.nextInt();
        }
        int sol=minNumberOfHours(initialEnergy, initialExperience, energy, experience);
        System.out.println(sol);
        scan.close();
    }  

    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int solution=0;
        int energySum=0;
        for (int i = 0; i < energy.length; i++) {
            energySum+=energy[i];
        }
        if(initialEnergy-energySum<=0){
            solution=energySum-initialEnergy+1;
        }
        for (int i = 0; i < experience.length; i++) {
            if(initialExperience<=experience[i]){
                solution+=experience[i]-initialExperience+1;
                initialExperience=experience[i]+1;
            }
            initialExperience+=experience[i];
        }
        return solution;
    }
}  
