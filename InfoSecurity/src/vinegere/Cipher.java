package vinegere;

public class Cipher {

    public String encode(String text, String key) {
        text=text.toUpperCase();
        key=key.toUpperCase();

        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < text.length(); i++, j++) {

            if (text.charAt(i) == ' ') {
                j--;
                continue;
            }
            if (j == key.length()) {
                j = 0;
            }
            sb.append(Character.toString((char) ((text.charAt(i) + key.charAt(j)) % 26 + 65)));
        }
        return sb.toString();
    }

    public String decode(String text, String key) {
        text=text.toUpperCase();
        key=key.toUpperCase();

        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < text.length(); i++, j++) {
            if (j == key.length()) {
                j = 0;
            }
            
          int difference =   text.charAt(i) - key.charAt(j);
          int modulus=(difference<0)? (26-(Math.abs(difference)%26))%26 :difference%26;
         sb.append(Character.toString((char) (modulus + 65)));
        }
        return sb.toString();
    }
}
