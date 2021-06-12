# encryption-decryption
A program to encrypt and decrypt content


# How to use:
Run the program using the Java main command. Insert the parameters and values of your choice. The options are:

#### mode: Choose between encryption or decryption mode
-mode:
  enc
  dec

#### in: Encrypt or decrypt text from a file
-in:
  filename

#### out: Save output in a file
  out: 
   filename

#### key: The number you would like to offset each character by
  -key:
     <#>

#### data: Pass a message as a parameter to be encrypted or decrypted
  -data:
       "This is the message I want to encrypt/decrypt"

#### alg: The algorithm you would like to use for encryption or decryption
   -alg:
       shift
       unicode
       

### Sample input:
      java Main -key 5 -alg shift -data "This is a message to be encoded" -mode enc
       
      java Main -mode enc -in road_to_treasure.txt -out protected.txt -key 5 -alg unicode
      
      
# UML Diagram:
### Strategy Design Pattern
 ![image](https://github.com/mpmcgee/encryption-decryption/blob/main/UML.PNG)

       
