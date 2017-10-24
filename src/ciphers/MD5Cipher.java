/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciphers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author Sudarsan T J
 */
public class MD5Cipher {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scan = new Scanner(System.in);
        String input, md5;
        System.out.println("Enter the Text: ");
        input = scan.next();
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(input.getBytes(),0,input.length());
        md5 = new BigInteger(1,md.digest()).toString();
        System.out.println("Hash Value: " + md5);
    }
}

/*
OUTPUT:
Enter the Text: 
hello
Hash Value: 123957004363873451094272536567338222994
*/
