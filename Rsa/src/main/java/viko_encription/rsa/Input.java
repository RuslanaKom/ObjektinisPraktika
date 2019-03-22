package viko_encription.rsa;

import java.util.ArrayList;
import java.util.List;

public class Input {
    
    private RsaEncripter encrypter = new RsaEncripter();

    public void getAndEncrypt(String str) {
        encrypter.calculateKeys(53L, 59L);
       String result2 = encrypter.decrypt(encrypter.encrypt(str));
        
    }
    
}
