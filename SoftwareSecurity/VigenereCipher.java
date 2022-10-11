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


class VigenereCipher
{
 
// This function generates the key in
// a cyclic manner until it's length isn't
// equal to the length of original text
static String generateKey(String str, String key)
{
    int x = str.length();
 
    for (int i = 0; ; i++)
    {
        if (x == i)
            i = 0;
        if (key.length() == str.length())
            break;
        key+=(key.charAt(i));
    }
    return key;
}
 
// This function returns the encrypted text
// generated with the help of the key
static String cipherText(String str, String key)
{
    String cipher_text="";
 
    for (int i = 0; i < str.length(); i++)
    {
        // converting in range 0-25
        int x = (str.charAt(i) + key.charAt(i)) %26;
 
        // convert into alphabets(ASCII)
        x += 'A';
 
        cipher_text+=(char)(x);
    }
    return cipher_text;
}
 
// This function decrypts the encrypted text
// and returns the original text
static String originalText(String cipher_text, String key)
{
    String orig_text="";
 
    for (int i = 0 ; i < cipher_text.length() &&
                            i < key.length(); i++)
    {
        // converting in range 0-25
        int x = (cipher_text.charAt(i) -
                    key.charAt(i) + 26) %26;
 
        // convert into alphabets(ASCII)
        x += 'A';
        orig_text+=(char)(x);
    }
    return orig_text;
}
 
// This function will convert the lower case character to Upper case
static String LowerToUpper(String s)
{
    StringBuffer str =new StringBuffer(s);
    for(int i = 0; i < s.length(); i++)
    {
        if(Character.isLowerCase(s.charAt(i)))
        {
            str.setCharAt(i, Character.toUpperCase(s.charAt(i)));
        }
    }
    s = str.toString();
    return s;
}
 
// Driver code
public static void main(String[] args)
{
    String Str = "SOFTWARESECURITY";
    String Keyword = "AYU";//Length is 3
       
    String str = LowerToUpper(Str);
    String keyword = LowerToUpper(Keyword);
 
    String key = generateKey(str, keyword);
    String cipher_text = cipherText(str, key);
 
    System.out.println("Ciphertext : "
        + cipher_text + "\n");
 
    System.out.println("Original/Decrypted Text : "
        + originalText(cipher_text, key));
    }
}