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

public class test100 {
    //convert roman to english no
    //limit 30 no
    //example
    /*
     * i - 1
v - 5
x - 10
xi - 11
xiv - 14
xiii  -13
xviii - 18
xxix - 29
xxx - 30
     */
    public static void main(String args[]){
        int solution=convertRomanToEnglish("ix");
        System.out.println(solution);
    }

    public static int convertRomanToEnglish(String input){
        int solution=0;
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i)=='x'){
                if(i!=0 && input.charAt(i-1)=='i'){
                    solution+=8;
                }else{
                    solution+=10;
                }
                
            }
            if(input.charAt(i)=='v'){
                if(i!=0 && input.charAt(i-1)=='i'){
                    solution+=3;
                }else{
                    solution+=5;
                }
            }
            if(input.charAt(i)=='i'){
                solution+=1;
            }
        }
        return solution;
    }

}
