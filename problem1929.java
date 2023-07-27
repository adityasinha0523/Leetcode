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
class problem1929{  
    public static void main(String args[]){  
        
        //System.out.println("Hello Java"); 
        int[] temp=new int[]{1,2,1};
        int [] sol=getConcatenation(temp);
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
    }  

    public static int[] getConcatenation(int[] nums) {
        int[] sol=new int[nums.length*2];
        int k=0;
        for (int i = 0; i < nums.length; i++) {
            sol[k++]=nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            sol[k++]=nums[i];
        }
        return sol;
    }
}  