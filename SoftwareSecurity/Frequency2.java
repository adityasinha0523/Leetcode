
import java.util.*;

public class Frequency2 {

	static Scanner sc = new Scanner(System.in);

	public static StringBuffer spl(String text)
	{
		StringBuffer result= new StringBuffer();
		/* Encryption using Caesar Cipher test:
		 * for (int i=0; i<text.length(); i++) {
			if (Character.isUpperCase(text.charAt(i))) {
				char ch = (char)(((int)text.charAt(i) + s - 65) % 26 + 65);
				result.append(ch); }
			else if(text.charAt(i)==' ') {
				char ch = ' ';
				result.append(ch); }
			else {
				char ch = (char)(((int)text.charAt(i) + s - 97) % 26 + 97);
				result.append(ch); }
		} */ 
		
		//Splitting the text into characters for StringBuffer
		text = text.toLowerCase();
		for (int i=0; i< text.length(); i++) {
			char ch = text.charAt(i);
			result.append(ch);
		}
	
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringBuffer s = new StringBuffer();
		System.out.println("Enter the ciphertext to be decrypted: ");
		String st = sc.nextLine();
		s = spl(st);
		//System.out.println(s.length()); 
		System.out.println("\nCipher text is: "+s);

 
		int [] ch = new int[26];
		for (int i=0; i<s.length(); i++)
			ch[s.charAt(i)-'a']++;
		int max=Integer.MIN_VALUE, l=0, k;
        List<Integer> l1=new ArrayList<>();
		for (int i=0; i<ch.length; i++){
			if (ch[i]>0){
                l1.add(i);
			}
		}
        
        for (int t = 0; t < l1.size(); t++) {
            for (int tt = 0;tt < 26; tt++) {
            
            StringBuffer result= new StringBuffer();
            k=l1.get(t)-tt; 
            for (int i=0; i<s.length(); i++){
			char ch1 = (char)(((int)s.charAt(i) -k -97)%26  + 97);
            result.append(ch1);}

		System.out.println("The key is "+k);
		System.out.println("The plaintext message is "+result);
            }
        }
    }
}
