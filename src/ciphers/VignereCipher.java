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
public class VignereCipher {
    public static void main(String args[]){
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter the Message: ");
                char msg[] = scan.next().toUpperCase().toCharArray();
                System.out.println("Enter the Key: ");
		char key[] = scan.next().toUpperCase().toCharArray();
		
                int msglen = msg.length, i , j;
                
                char newkey[] = new char[msglen];
                char enc[] = new char[msglen];
                char dec[] = new char[msglen];
                
                for(i=0,j=0;i<msglen; i++,j++){
                    if(j== key.length)
                        j=0;
                    newkey[i] = key[j];
                }
                
                //Encryption
                for(i=0;i<msglen;i++){
                    enc[i] = (char) (((msg[i] + newkey[i])%26)+'A');
                }
                
                //Decryptiom
                for(i=0;i<msglen;i++){
                    dec[i] = (char) ((((enc[i] - newkey[i])+26)%26) + 'A');
                }
                
                System.out.println("Original Message : " + String.valueOf(msg));
                System.out.println("Key : " + String.valueOf(key));
                System.out.println("Generated Key : " + String.valueOf(newkey));
                System.out.println("Encrypted Text : " + String.valueOf(enc));
                System.out.println("Decryption Text : " + String.valueOf(dec));
                
	}
}

/*
OUTPUT:
Enter the Message: 
hellocipher
Enter the Key: 
good
Original Message : HELLOCIPHER
Key : GOOD
Generated Key : GOODGOODGOO
Encrypted Text : NSZOUQWSNSF
Decryption Text : HELLOCIPHER
*/