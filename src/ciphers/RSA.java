/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciphers;

import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author Sudarsan T J
 */
public class RSA {
    private BigInteger N;
    private BigInteger p;
    private BigInteger q;
    private BigInteger e;
    private BigInteger d;
    private BigInteger phi;
    private Random r;
    private int bitlength = 1024;

    public RSA() {
        r = new Random();
        p = BigInteger.probablePrime(bitlength, r);
        q = BigInteger.probablePrime(bitlength, r);
        N = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(bitlength/2,r);
        while(phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0){
            e.add(BigInteger.ONE);
        }
        d = e.modInverse(phi);
    }

    public RSA(BigInteger N, BigInteger e, BigInteger d){
        this.N = N;
        this.e = e;
        this.d = d;
    }
    
    public static void main(String[] args) throws IOException {
        RSA rsa = new RSA();
        DataInputStream in = new DataInputStream(System.in);
        System.out.println("Enter the Text: ");
        String input = in.readLine();
        System.out.println("Encrypting Text: " + input);
        System.out.println("Byte of input message: " + bytetostring(input.getBytes()));
        
        //encrypt
        byte[] enc = rsa.encrypt(input.getBytes());
        
        //decrypt
        byte[] dec = rsa.decrypt(enc);
        
        System.out.println("Decrypting Bytes: " + bytetostring(dec));
        System.out.println("Decrypted Text: " + new String(dec));
    }
    
    public static String bytetostring(byte [] encrypted){
        String test = "";
        for(byte b : encrypted){
            test += Byte.toString(b);
        }
        return test;
    }
    
    public byte[] encrypt(byte [] message){
        return (new BigInteger(message)).modPow(e, N).toByteArray();
    } 
    
    public byte [] decrypt(byte [] ciphertext){
        return  (new BigInteger(ciphertext)).modPow(d, N).toByteArray();
    }
}

/*
OUTPUT:
Enter the Text: 
hello
Encrypting Text: hello
Byte of input message: 104101108108111
Decrypting Bytes: 104101108108111
Decrypted Text: hello
*/