package viko_encription.rsa;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private Output output;
    private RsaEncripter encrypter = new RsaEncripter();

    public void encryptAndSend(String str) {
        encrypter.calculateKeys(53L, 59L);
        //String result2 = encrypter.decrypt(encrypter.encrypt(str));
        output.receiveMessage(encrypter.encrypt(str));
        output.receiveKey(encrypter.getDecryptionKey(), encrypter.getModulus());
    }

    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public RsaEncripter getEncrypter() {
        return encrypter;
    }

    public void setEncrypter(RsaEncripter encrypter) {
        this.encrypter = encrypter;
    }
    
}
