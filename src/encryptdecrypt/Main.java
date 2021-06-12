package encryptdecrypt;
import java.io.IOException;
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileWriter;



public class Main {

    //read file input and convert to string
    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    //write output to file
    public static void writeFile(String msg, String output) {

        try {
            File file = new File(output);
            FileWriter writer = new FileWriter(file);
            writer.write(msg);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            // Handle the exception
        }


    }


    //main method
    public static void main(String[] args) {

        //declare variables
        String mode = "enc"; //defaults to encrypt
        String alg = "shift"; //defaults to shift algorithm
        int key = 0; //defaults to key 0
        String data = "";
        String fileIn = "";
        String output = "";

        //loops through args array and stores content as variables
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
                    case ("-alg"):
                        alg = args[i + 1];
                }

            }
        }

        //determine whether content will be encrypted or decrypted
        switch (mode) {
            //encryption case
            case "enc":

                //create a new message encrypter object
                MessageEncrypter encrypter = new MessageEncrypter();

                //check input and set proper algorithm
                if ("shift".equals(alg)) {
                    encrypter.setMethod(new ShiftEncryptMethod());
                } else if ("unicode".equals(alg)) {
                    encrypter.setMethod(new UnicodeEncryptMethod());
                }

                //if there is no file input, get data from command line input
                if (!"".equals(data) && "".equals(fileIn)) {
                    System.out.println(encrypter.encrypt(data, key));

                    //if there is a file input, get the data from the file
                } else if (data.equals("") && !fileIn.equals("")) {

                    //convert file to string
                    try {
                        data = readFileAsString(fileIn);

                        //throw exception
                    } catch (IOException e) {
                        System.out.printf("An exception occurs %s", e.getMessage());
                    }

                    //if an output parameter was not entered, print encrypted message
                    if (output.equals("")) {
                        System.out.println(encrypter.encrypt(data, key));

                        //if an output parameter was entered, output encrypted message in a file with said filename
                    } else {
                        writeFile(encrypter.encrypt(data, key), output);
                    }
                }
                break;
            //Decryption case
            case "dec":

                //create a new message decrypter object
                MessageDecrypter decrypter = new MessageDecrypter();

                //check input and set proper algorithm
                if ("shift".equals(alg)) {
                    decrypter.setMethod(new ShiftDecryptMethod());
                } else if ("unicode".equals(alg)) {
                    decrypter.setMethod(new UnicodeDecryptMethod());
                }

                //if there is no file input, get data from command line input
                if (!"".equals(data) && "".equals(fileIn)) {
                    System.out.println(decrypter.decrypt(data, key));

                    //if there is a file input, get the data from the file
                } else if (data.equals("") && !fileIn.equals("")) {

                    //convert file to string
                    try {
                        data = readFileAsString(fileIn);

                        //throw exception
                    } catch (IOException e) {
                        System.out.printf("An exception occurs %s", e.getMessage());
                    }

                    //if an output parameter was not entered, print decrypted message
                    if (output.equals("")) {
                        System.out.println(decrypter.decrypt(data, key));

                        //if an output parameter was entered, output decrypted message in a file with said filename
                    } else {
                        writeFile(decrypter.decrypt(data, key), output);
                    }
                }
                break;
        }
    }
}


