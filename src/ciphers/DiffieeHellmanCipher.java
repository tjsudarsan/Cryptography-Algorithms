/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciphers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 *
 * @author Sudarsan T J
 */
public class DiffieeHellmanCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the Prime Number: ");
        BigInteger prime = new BigInteger(bf.readLine());
        System.out.println("Enter the Premitive Root of " + prime + ": ");
        BigInteger proot = new BigInteger(bf.readLine());
        System.out.println("Enter the Person A's Secret Number less then " + prime +": ");
        BigInteger a = new BigInteger(bf.readLine());
        System.out.println("Enter the Person B's Secret Number less then " + prime +": ");
        BigInteger b = new BigInteger(bf.readLine());
        
        BigInteger R1 = proot.modPow(a, prime);
        System.out.println("R1 = " + R1);
        
        BigInteger R2 = proot.modPow(b, prime);
        System.out.println("R2 = " + R2);
        
        BigInteger K1 = R2.modPow(a, prime);
        System.out.println("Key Calculated for A is " + K1);
        BigInteger K2 = R1.modPow(b, prime);
        System.out.println("Key Calculated for B is " + K2);
    }
}

/*
Output:
Enter the Prime Number: 
7
Enter the Premitive Root of 7: 
3
Enter the Person A's Secret Number less then 7: 
5
Enter the Person B's Secret Number less then 7: 
3
R1 = 5
R2 = 6
Key Calculated for A is 6
Key Calculated for B is 6
*/