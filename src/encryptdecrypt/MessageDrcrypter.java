package encryptdecrypt;

//Context: sets and invokes strategy
class MessageDecrypter {
    private DecryptionMethod method;

    //set the decryption method
    public void setMethod(DecryptionMethod method) {
        this.method = method;
    }

    //invoke chosen decryption method
    public String decrypt(String msg, int key) {
        return this.method.decrypt(msg, key);
    }
}

