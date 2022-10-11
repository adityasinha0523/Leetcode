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
//Class CaesarCipher
class CaesarCipher
{
    //REMOVE THIS LINE before submiting Code Link:https://www.geeksforgeeks.org/caesar-cipher-in-cryptography/
    /*Function to encrypt the string with given integer as a argument.
     * @return none
     */
    public static StringBuffer encryptString(String inputText, int number)
    {
        //Storing answer in StringBuffer
        StringBuffer result= new StringBuffer();
 
        for (int i=0; i<inputText.length(); i++)
        {
            //Checking if Character is upper case.
            if (Character.isUpperCase(inputText.charAt(i)))
            {
                char ch = (char)(((int)inputText.charAt(i) +
                                  number - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                //Checking if Character is lower case.
                char ch = (char)(((int)inputText.charAt(i) +
                                  number - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }
 
    
    public static void main(String[] args)
    {
        String inputText = "SoftwareSecurity";
        int number = 10;
        System.out.println("Input Text  : " + inputText);
        System.out.println("Shift Value : " + number);
        System.out.println("Cipher Output: " + encryptString(inputText, number));
    }
}
