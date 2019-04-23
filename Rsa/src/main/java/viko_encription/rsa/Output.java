package viko_encription.rsa;

import org.apache.commons.codec.digest.DigestUtils;

public class Output {
    
    private RsaEncripter encrypter = new RsaEncripter();
    
    private String message;
    private Long deKey;
    private Long modulus;
    private byte [][] signature;

    public void receiveMessage(String message, byte [][] signature, Long deKey, Long modulus) {
        //signature[0][0]=1; // (for testing)
    	this.signature=signature;
        this.message=message;
        this.deKey=deKey;
        this.modulus=modulus;
    }
    
    public Boolean checkSignature() {
       String decryptedSignatureHash =  encrypter.decrypt(signature, deKey, modulus);
       String messageHash = DigestUtils.sha256Hex(message);
        return decryptedSignatureHash.equals(messageHash);
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

    
    
}
