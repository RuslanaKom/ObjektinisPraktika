package viko_encription.rsa;

public class Output {
    
    private RsaEncripter encrypter = new RsaEncripter();
    
    private String message;
    private Long deKey;
    private Long modulus;
    private byte [][] receivedMessage;

    public void receiveMessage(byte [][] message) {
        this.receivedMessage=message;
    }
    
    public void receiveKey(long exponent, long modulus) {
        this.deKey = exponent;
        this.modulus = modulus;
    }
    
    public String decrypt() {
        return encrypter.decrypt(receivedMessage, deKey, modulus);
    }
}
