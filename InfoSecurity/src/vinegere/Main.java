package vinegere;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cipher cipher = new Cipher();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Text to encode: ");
        String  text= scan.nextLine();
        System.out.println("Key: ");
        String  key= scan.nextLine();
        
        System.out.println(cipher.encode(text, key));
        
        System.out.println("Text to decode: ");
        String  text2= scan.nextLine();
        System.out.println("Key: ");
        String  key2= scan.nextLine();
        
        System.out.println(cipher.decode(text2, key2)); 

        
       // System.out.println(cipher.decode(cipher.encode("This is a testing text", "po"), "po"));
    }
}
