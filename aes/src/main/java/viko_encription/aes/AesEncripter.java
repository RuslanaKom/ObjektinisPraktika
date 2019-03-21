package viko_encription.aes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AesEncripter {
    
    private static final String key = "aesEncryptionKey";
    private static final String initVector = "encryptionIntVec";
    
    public void encryptAndSave(String string, String fileName){
        try {
            writeToFile(encrypt(string), fileName);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String readAndDecrypt( String fileName) {
        try {
            return decrypt(readFromFile(fileName));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    

    private String encrypt(String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.encodeBase64String(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
   private String decrypt(String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
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
