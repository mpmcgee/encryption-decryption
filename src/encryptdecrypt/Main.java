package encryptdecrypt;
import java.lang.*;
//import java.util.Scanner;


public class Main {

    public static void encrypt(String msg) {

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

        System.out.println(encMsg);

    }

    public static void keyEncrypt(String msg, int key) {

        String encMsg="";
        int x;

        for (int i = 0; i < msg.length(); i++) {
            // if (!(Character.isLetter(msg.charAt(i)))) {
            //     x = msg.charAt(i);
            // } else {
            x = msg.charAt(i) + key;
            // while (x > 122) {
            //     x -= 26;
            // }


            // }

            encMsg += String.valueOf((char)x);
        }



        System.out.println(encMsg);
    }

    public static void keyDecrypt(String msg, int key) {
        String encMsg="";
        int x;

        for (int i = 0; i < msg.length(); i++) {
            // if (!(Character.isLetter(msg.charAt(i)))) {
            //     x = msg.charAt(i);
            // } else {
            x = msg.charAt(i) - key;
            // while (x > 122) {
            //     x -= 26;
            // }


            // }

            encMsg += String.valueOf((char)x);
        }


        System.out.println(encMsg);
    }



    public static void main(String[] args) {

        String mode = "enc";
        String data = "";
        int key = 0;

        for (int i = 0; i < args.length; i++) {
            if (i + 1 < args.length) {
                switch (args[i]) {
                    case("-mode"):
                        mode = args[i+1];
                        break;
                    case("-key"):
                        key = Integer.parseInt(args[i+1]);
                        break;
                    case("-data"):
                        data = args[i+1];
                        break;
                }

            }
        }

        if ("enc".equals(mode)) {
            keyEncrypt(data, key);
        } else {
            keyDecrypt(data, key);
        }
    }





    // switch(args[0]) {
    //     case "-mode":
    //     if ("enc".equals(args[1])){
    //         if("-key".equals(args[2])){
    //             keyEncrypt(args[5], Integer.parseInt(args[3]));
    //             break;
    //         } else if ("-data" ==  args[2]){
    //             keyEncrypt(args[3], 0);
    //             break;
    //         } else {
    //             keyEncrypt("", 0);
    //             break;
    //         }
    //     } else if ("dec".equals(args[1])){
    //         if("key".equals(args[2])){
    //             keyDecrypt(args[5], Integer.parseInt(args[3]));
    //             break;
    //         } else if ("-data" ==  args[2]){
    //             keyDecrypt(args[3], 0);
    //             break;
    //         } else {
    //             keyDecrypt("", 0);
    //             break;
    //         }
    //     }
    //     case ("-key"):
    //         if ("-data" == args[2]) {
    //             keyEncrypt(args[1], Integer.parseInt(args[3]));
    //             break;
    //         } else {
    //             keyEncrypt("", Integer.parseInt(args[3]));
    //                 break;
    //             }
    //         case ("-data"):
    //               keyEncrypt(args[1], 0);

    //         default:
    //             System.out.println("invalid input");
    //     }
    // }
}
