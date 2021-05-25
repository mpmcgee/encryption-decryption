package encryptdecrypt;
import java.lang.*;

public class Main {

    public static String encrypt(String msg) {

        String encMsg="";
        int x;

        for (int i = 0; i < msg.length(); i++) {
            if (String.valueOf(msg.charAt(i)).equals(" ") || String.valueOf(msg.charAt(i)).equals("!")) {
                x = msg.charAt(i);
            } else {
                x = 122 - (msg.charAt(i)) + 97;
            }
            encMsg += String.valueOf((char)x);
        }

        return encMsg;

    }
    public static void main(String[] args) {

        System.out.println(encrypt("we found a treasure!"));
    }
}
