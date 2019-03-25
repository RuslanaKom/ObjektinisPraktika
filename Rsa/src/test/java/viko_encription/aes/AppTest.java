package viko_encription.aes;

import junit.framework.TestCase;
import viko_encription.rsa.Input;
import viko_encription.rsa.Output;
import viko_encription.rsa.RsaEncripter;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    RsaEncripter enc = new RsaEncripter();
    Input input = new Input();
    Output output = new Output();
    
   public void test() {
       input.setOutput(output);
       input.encryptAndSend("mama myla ramu");
       System.out.println(output.decrypt());
   }
}
