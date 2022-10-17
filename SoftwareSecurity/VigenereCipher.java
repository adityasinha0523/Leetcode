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
 public static String generateKey(String str, List<String> keys, String cipher_text )
{
    String res="";
    int x = str.length();
    for(int j= 0; j<keys.size(); j++){
        String orginalKey =keys.get(j);
        String currentKey = keys.get(j);
    for (int i = 0; ; i++)
    {   
        if (x == i)
            i = 0;
        if (currentKey.length() == str.length())
            break;
        currentKey+=(currentKey.charAt(i));
    }
    //System.out.println("Current key value"+currentKey);
    res =cipherText(str,currentKey );
    //System.out.println("Res value is "+res);
    if (res.equals(cipher_text.toLowerCase())){
        //System.out.println("Inside if");
        return orginalKey; 
    }
    }
    return "";
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
        x += 'a';
 
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


public static List<String> Keygeneration() {
    List<String> list1 = new ArrayList<String>();
    for (char c1 ='a'; c1<='z'; c1++){
        for(char c2 ='a'; c2<='z'; c2++){
            for(char c3 ='a'; c3<='z'; c3++){
            StringBuilder sb=new StringBuilder();
            sb.append(c1);
            sb.append(c2);
            sb.append(c3);
            String s=sb.toString();
            s=s.toUpperCase();  
            list1.add(s);
            }
        }
    }
    return list1;
    }

// Driver code
public static void main(String[] args)
{  List<String> KeysList= Keygeneration();
    for (int i = 0; i < KeysList.size(); i++) {
        System.out.println(KeysList.get(i));
    }
    String Str1 = "ARIZONASTATEUNIVERSITY";    
    String cipher_text1 = "EUCDRHEVNEWYYQCZHLWLNC";

    String key1 = generateKey(Str1, KeysList,cipher_text1);
    System.out.println("Key for First Input:"+ key1);
    String Str2 = "COMPUTERSCIENCE";    
    String cipher_text2 = "GRGTXNIUMGLYRFY";
    String key2 = generateKey(Str2, KeysList,cipher_text2);
    System.out.println("Key for Second Input:"+ key2);
    }
}