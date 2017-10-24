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
public class RailfenceCipher {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println("Ente the depth");
        int depth=in.nextInt();
        System.out.println("Enter the text: ");
        String input=in.next().toLowerCase();
        String output="";
        char[] decrypt=new char[input.length()];
        int len=input.length(),flag=0;
        System.out.println("Input string is "+ input);
        int i=0;
        while(i!=depth)
        {
            for(int j=i;j<len;j=j+depth)
            {
                output+=input.charAt(j);
            }
            i++;
        }
       
        System.out.println("Cipher text:"+output);
        //Decrypt
        int index=0;
        i=0;
        while(i!=depth)
        {
            for(int j=i;j<len;j=j+depth)
            {
                decrypt[j]=output.charAt(index);
                index++;
            }
            i++;
        }
       
     System.out.println("Decrypted message:"+String.valueOf(decrypt));
    }
}
