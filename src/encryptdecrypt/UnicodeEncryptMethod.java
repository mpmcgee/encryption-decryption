package encryptdecrypt;

//Concrete strategy 2: Unicode Shift Encryption
class UnicodeEncryptMethod implements EncryptionMethod {

    @Override
    public String encrypt(String msg, int key) {

        StringBuilder result = new StringBuilder();
        //for each character in message
        for (char character : msg.toCharArray()) {

            //set original position as integer
            int originalAlphabetPosition = character;

            //offset original character by the shift value
            char newCharacter = (char) (originalAlphabetPosition + key);

            //append character to string builder
            result.append(newCharacter);
        }

        //return encrypted message as string
        return result.toString();
    }

}
