package viko_encription.rsa;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

public class Input {
    private Output output;
    private RsaEncripter encrypter = new RsaEncripter();

    public void encryptAndSend(String message) {
        encrypter.calculateKeys(53L, 59L);
        String messageHash = DigestUtils.sha256Hex(message);

        output.receiveMessage(message, encrypter.encrypt(messageHash), encrypter.getDecryptionKey(), encrypter.getModulus());
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
