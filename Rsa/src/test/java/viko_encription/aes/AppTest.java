package viko_encription.aes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import junit.framework.TestCase;
import viko_encription.rsa.Input;
import viko_encription.rsa.Output;
import viko_encription.rsa.RsaEncripter;

/**
 * Unit test for simple App.
 */
public class AppTest {
	RsaEncripter enc = new RsaEncripter();
	Input input = new Input();
	Output output = new Output();

	@Test
	public void shouldAcceptSignature() {
		input.setOutput(output);
		input.encryptAndSend("mama myla ramu");
		Boolean signatureAccepted = output.checkSignature();
		assertTrue(signatureAccepted);

	}

	@Test
	public void shouldNotAcceptSignature() {
		input.setOutput(output);
		input.encryptAndSend("mama myla ramu");
		output.setMessage("nnnnnn");
		Boolean signatureAccepted = output.checkSignature();
		assertFalse(signatureAccepted);
	}
}
