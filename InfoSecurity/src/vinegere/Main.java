package vinegere;

public class Main {

    public static void main(String[] args) {
        Cipher cipher = new Cipher();
        System.out.println(cipher.decode(cipher.encode("This is a testing text", "aete"), "aete"));
    }
}
