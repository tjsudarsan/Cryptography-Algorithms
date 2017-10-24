/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciphers;

import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Sudarsan T J
 */
public class DESCipher {
    public static void main(String[] args) throws Exception{
        System.out.println("Enter The Message: ");
        Scanner scan = new Scanner(System.in);
        String message = scan.next();
        
        SecretKey secretKey;
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        secretKey = keyGenerator.generateKey();
        System.out.println("DES Key: " + DatatypeConverter.printHexBinary(secretKey.getEncoded()));
        
        Cipher enccipher = Cipher.getInstance("DES");
        enccipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] ciphertext = enccipher.doFinal(message.getBytes());
        System.out.println("Encrypted Data: " + DatatypeConverter.printHexBinary(ciphertext));
        
        Cipher decCipher = Cipher.getInstance("DES");
        decCipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] plaintext = decCipher.doFinal(ciphertext);
        System.out.println("Decrypted Code: " + new String(plaintext));
    }
}

/*
OUTPUT:
Enter The Message: 
thisistj
Encrypted Data: B35A761A53D8CCFEB088C4B32A075592
Decrypted Code: thisistj
*/