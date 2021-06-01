package encryptdecrypt;
import java.io.IOException;
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileWriter;
//import java.util.Scanner;


public class Main {

    public static void encrypt(String msg) {

        String encMsg = "";
        int x;

        for (int i = 0; i < msg.length(); i++) {
            if (String.valueOf(msg.charAt(i)).equals(" ") || String.valueOf(msg.charAt(i)).equals("!")) {
                x = msg.charAt(i);
            } else {
                x = 122 - (msg.charAt(i)) + 97;
            }
            encMsg += String.valueOf((char) x);
        }

        System.out.println(encMsg);

    }

    public static String keyEncrypt(String msg, int key) {

        String encMsg = "";
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

            encMsg += String.valueOf((char) x);
        }


        return encMsg;
    }

    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void keyEncryptFile(String msg, int key, String output) {

        String encMsg = "";
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

            encMsg += String.valueOf((char) x);
        }

        try {
            File file = new File(output);
            FileWriter writer = new FileWriter(file);
            writer.write(encMsg);
            writer.close();

        } catch (IOException e) {
            // Handle the exception
        }

    }

    public static void keyDecryptFile(String msg, int key, String output) {
        String encMsg = "";
        int x;

        String content = "";
        int max = 0;

        for (int i = 0; i < msg.length(); i++) {
            // if (!(Character.isLetter(msg.charAt(i)))) {
            //     x = msg.charAt(i);
            // } else {
            x = msg.charAt(i) - key;
            // while (x > 122) {
            //     x -= 26;
            // }


            // }

            encMsg += String.valueOf((char) x);
        }


        try {
            File file = new File(output);
            FileWriter writer = new FileWriter(file);
            writer.write(encMsg);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            // Handle the exception
        }


    }

    public static String keyDecrypt(String msg, int key) {
        String encMsg = "";
        int x;

        String content = "";
        int max = 0;

        for (int i = 0; i < msg.length(); i++) {
            // if (!(Character.isLetter(msg.charAt(i)))) {
            //     x = msg.charAt(i);
            // } else {
            x = msg.charAt(i) - key;
            // while (x > 122) {
            //     x -= 26;
            // }


            // }

            encMsg += String.valueOf((char) x);
        }


        return encMsg;
    }


    public static void main(String[] args) {

        String mode = "enc";
        String data = "";
        int key = 0;
        String fileIn = "";
        String output = "";

        for (int i = 0; i < args.length; i++) {
            if (i + 1 < args.length) {
                switch (args[i]) {
                    case ("-mode"):
                        mode = args[i + 1];
                        break;
                    case ("-in"):
                        fileIn = args[i + 1];
                        break;
                    case ("-out"):
                        output = args[i + 1];
                        break;
                    case ("-key"):
                        key = Integer.parseInt(args[i + 1]);
                        break;
                    case ("-data"):
                        data = args[i + 1];
                        break;
                }

            }
        }


        switch (mode) {
            case "enc":
                if (!data.equals("") && fileIn.equals("")) {
                    System.out.println(keyEncrypt(data, key));
                } else if (data.equals("") && !fileIn.equals("")) {

                    try {
                        data = readFileAsString(fileIn);
                    } catch (IOException e){
                        System.out.printf("An exception occurs %s", e.getMessage());
                    }

                    if (output.equals("")) {

                        System.out.println(keyEncrypt(data, key));
                    } else {
                        keyEncryptFile(data, key, output);
                    }
                }
                break;

            case "dec":
                if (!data.equals("") && fileIn.equals("")) {
                    System.out.println(keyDecrypt(data, key));
                } else if (data.equals("") && !fileIn.equals("")) {

                    try {
                        data = readFileAsString(fileIn);
                    } catch (IOException e){
                        System.out.printf("An exception occurs %s", e.getMessage());
                    }

                    if (output.equals("")) {

                        System.out.println(keyDecrypt(data, key));
                    } else {
                        keyDecryptFile(data, key, output);
                    }
                }
                break;



        }
    }
}
//                if ("enc".equals(mode)) {
//                    keyEncryptFile(data, key, output);
//                } else {
//                    keyDecryptFile(data, key, output);
//                }
//            } else {
//                if ("enc".equals(mode)) {
//                    keyEncrypt(data, key);
//                } else {
//                    keyDecrypt(data, key);
//                }
//            }





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

