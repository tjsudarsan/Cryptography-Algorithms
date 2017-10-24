/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciphers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author Sudarsan T J
 */
public class SHACipher {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("Enter the Text: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        MessageDigest sha = MessageDigest.getInstance("SHA1");
        byte[] result = sha.digest(input.getBytes());
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<result.length;i++){
            stringBuffer.append(Integer.toString((result[i]&0xff)+0x100,16).substring(1));
        }
        System.out.println("Hashed Code: " + stringBuffer.toString());
    }
}
