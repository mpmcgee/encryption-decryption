package encryptdecrypt;
import java.lang.*;
import java.util.Scanner;


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

    public static String keyEncrypt(String msg, int key) {

        String encMsg="";
        int x;

        for (int i = 0; i < msg.length(); i++) {
            if (!(Character.isLetter(msg.charAt(i)))) {
                x = msg.charAt(i);
            } else {
                x = msg.charAt(i) + key;
                while (x > 122) {
                    x -= 26;
                }
            }

            encMsg += String.valueOf((char)x);
        }
        return encMsg;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        int key = scanner.nextInt();

        System.out.println(keyEncrypt(message, key));
    }
}