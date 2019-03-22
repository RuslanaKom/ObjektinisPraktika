package viko_encription.rsa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class RsaEncripter {
    
    private Long primeNr1;
    private Long primeNr2;
    private Long modulus;
    private Long encryptionKey;
    private Long decryptionKey;
    
    public void calculateKeys(Long one, Long two) {
        this.primeNr1=one;
        this.primeNr2=two;
        
        modulus = primeNr1 * primeNr2; //modulus
        Long L = (primeNr1 - 1) * (primeNr2 - 1); //quantity of numbers between primeNr1 and primeNr2 having no common factor with Modulus
        
        //encription key 1) must be between 1 and L
        //2) have no common factor with L and the Modulus  
        
        Long encryptionKey = 2L;
        
        for(; encryptionKey<L; encryptionKey++) {
            boolean coprimeWithL = checkIfCoprimes (encryptionKey, L);
            boolean coprimeWithN = checkIfCoprimes (encryptionKey, modulus);
            if (coprimeWithL && coprimeWithN) {
                break;
            }
        }
        this.encryptionKey=encryptionKey;
        
        //decryption key 
        Long  decryptionKey = encryptionKey;
        boolean result = false;
        while(!result) {
            decryptionKey++;
            if(decryptionKey*encryptionKey%L==1) {
                result=true;
            }
        }
        this.decryptionKey=decryptionKey;
        
        System.out.println("public key = "+ encryptionKey+ " ," + modulus);
        System.out.println("private key = "+ decryptionKey+ " ," + modulus);
    }
    
    public byte[][] encrypt(String string) {
        byte [][] finalArray= new byte [string.length()] [];
        for (int i = 0; i < string.length(); i++) {
            byte[] charInByte = string.substring(i, i+1).getBytes();

            System.out.println("Char in bytes is: " + Integer.toBinaryString(charInByte[0]));

            byte[] encodedChar = (new BigInteger(charInByte))
                    .modPow(BigInteger.valueOf(encryptionKey), BigInteger.valueOf(modulus)).toByteArray();

            System.out.println("Encoded char is: " + Integer.toBinaryString(encodedChar[0]));
            finalArray[i]=encodedChar;
        }
        return finalArray;
    }
    
    public String decrypt(byte[][]  encodedWord) {
        byte[][] decodedWord = new byte[encodedWord.length] [];
        for (int i = 0; i < encodedWord.length; i++) {
            byte[] decodedChar = (new BigInteger(encodedWord[i]))
                    .modPow(BigInteger.valueOf(decryptionKey), BigInteger.valueOf(modulus)).toByteArray();

            System.out.println("Decoded char in numbers is: " + Integer.toBinaryString(decodedChar[0]));

            decodedWord[i] = decodedChar;
        }
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<decodedWord.length; j++) {
            sb.append(new String(decodedWord[j]));
        }
        System.out.println("Decoded word is: "+ sb.toString());
        return sb.toString();
    }
    
    private boolean checkIfCoprimes(Long a, Long b) {
        while (a > 0 && b> 0)
        {
            if (a > b)
                a %= b;
            else
                b %= a;
        }
        return Math.max(a, b)==1 ? true : false;
    }
   
   private void writeToFile(String string, String fileName)  throws IOException {
       BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
       writer.write(string); 
       writer.close();
   }
   
   private String readFromFile(String fileName)  throws IOException {
       BufferedReader reader = new BufferedReader(new FileReader(fileName));
       String currentLine = reader.readLine();
       reader.close();
       return currentLine;
   }

}
