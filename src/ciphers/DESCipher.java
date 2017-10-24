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
DES Key: 674AE657E0E3F1F7
Encrypted Data: C5557717F7318EC12AD7B5AFA5AF7B43
Decrypted Code: thisistj
*/