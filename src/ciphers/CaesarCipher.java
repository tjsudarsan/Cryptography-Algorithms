/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciphers;

import java.util.Scanner;



/**
 *
 * @author Sudarsan T J
 */
public class CaesarCipher {
    
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static String encrypt(String plainText,int shiftKey){
        plainText = plainText.toLowerCase();
        String CipherText = "";
        for(int i = 0; i<plainText.length();i++){
            int Charpos = ALPHABET.indexOf(plainText.charAt(i));
            int keyval = (shiftKey + Charpos) % 26;
            char replacetext = ALPHABET.charAt(keyval);
            CipherText += replacetext;
        }
        return CipherText;
    }
    
    public static String decrypt(String ciphertext, int shiftkey){
        ciphertext = ciphertext.toLowerCase();
        String plaintext = "";
        for(int i = 0; i<ciphertext.length();i++){
            int charpos = ALPHABET.indexOf(ciphertext.charAt(i));
            int keyval = (charpos - shiftkey) % 26;
            if(keyval < 0){
                keyval = ALPHABET.length() + keyval;
            }
            char replace = ALPHABET.charAt(keyval);
            plaintext += replace;
        }
        return plaintext;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Text to encrypt: ");
        String input = scan.next();
        System.out.println("Encrypted Text: " + encrypt(input, 3));
        System.out.println("Decrypted Text: " + decrypt(encrypt(input, 3), 3));
    }
}
