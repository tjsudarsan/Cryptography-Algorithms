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
public class AESCipher {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter the Text: ");
        Scanner scan = new Scanner(System.in);
        String message = scan.next();
        
        SecretKey secretKey = getSecretEncryptionKey();
        byte[] ciphertext = encrypt(message,secretKey);
        String decrypted = decrypt(ciphertext,secretKey);
        
        System.out.println("Original Text: " + message);
        System.out.println("AES Key (HEX FORM): " + bytetoHEX(secretKey.getEncoded()));
        System.out.println("Encrypted Text: " + bytetoHEX(ciphertext));
        System.out.println("Decrypted Text: " + decrypted);
    }
    
    public static SecretKey getSecretEncryptionKey() throws Exception{
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey seckey = keyGenerator.generateKey();
        return seckey;
    }
    
    public static byte [] encrypt(String message, SecretKey secretKey) throws Exception{
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] ciphertext = aesCipher.doFinal(message.getBytes());
        return  ciphertext;
    }
    
    public static String decrypt(byte [] ciphertext, SecretKey secretKey) throws Exception{
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] plaintext = aesCipher.doFinal(ciphertext);
        return new String(plaintext);
    }
    
    public static String bytetoHEX(byte [] hash){
        return DatatypeConverter.printHexBinary(hash);
    }
}

/*
OUTPUT:
Enter the Text: 
hello
Original Text: hello
AES Key (HEX FORM): 508B83AF002EEBB653A98A93A8241799
Encrypted Text: E0A47E4996A55EC43DE545C41C1F19CC
Decrypted Text: hello
*/