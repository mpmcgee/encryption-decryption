package encryptdecrypt;

//Concrete strategy 1: Caesar Shift Decryption
class ShiftDecryptMethod implements DecryptionMethod {

    @Override
    public String decrypt(String msg, int key) {
        char A = 'a';
        StringBuilder result = new StringBuilder();
        for (char character : msg.toCharArray()) {
            //check to ensure character is a letter
            if (java.lang.Character.isLetter(character)) {

                //handle capital and lowercase letters
                if (Character.isUpperCase(character)) {
                    A = 'A';
                } else {
                    A = 'a';
                }

                //calculate original numerical position
                int originalAlphabetPosition = character - A;

                //calculate new numerical position in alphabet
                int newAlphabetPosition = (originalAlphabetPosition - key) % 26;

                //add 26 to alphabet positions that are less than 0 to handle negative positions
                if (newAlphabetPosition < 0) {
                    newAlphabetPosition = newAlphabetPosition + 26;
                }

                //create a new character by applying offset
                char newCharacter = (char) (A + newAlphabetPosition);

                //add character to string Builder
                result.append(newCharacter);

                //if character is not a letter, append it with no modification
            } else {
                result.append(character);
            }
        }
        //return resulting message as a string
        return result.toString();
    }
}
