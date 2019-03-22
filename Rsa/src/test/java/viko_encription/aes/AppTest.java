package viko_encription.aes;

import junit.framework.TestCase;
import viko_encription.rsa.Input;
import viko_encription.rsa.RsaEncripter;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    RsaEncripter enc = new RsaEncripter();
    Input input = new Input();
    
   public void test() {
      // enc.calculateKeys(2L, 7L);
       input.getAndEncrypt("mama myla ramu");
   }
}
