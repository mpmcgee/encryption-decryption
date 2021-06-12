package encryptdecrypt;

// Strategy design pattern for encryption

//interface (Strategy)
interface DecryptionMethod {

    String decrypt(String msg, int key);

}