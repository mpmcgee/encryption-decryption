package encryptdecrypt;

//Context: sets and invokes strategy
public class MessageEncrypter {
    private EncryptionMethod method;

    //set the encryption method
    public void setMethod(EncryptionMethod method) {
        this.method = method;
    }

    //invoke chosen encryption method
    public String encrypt(String msg, int key) {
        return this.method.encrypt(msg, key);
    }
}
