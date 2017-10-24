/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciphers;

import javax.swing.JOptionPane;

/**
 *
 * @author Sudarsan T J
 */
public class HillCipher {
    
    public static int [][] keymat = new int[][]{
        {1,2,3},
        {1,3,2},
        {2,2,1},
    };
    
    public static int [][] invkeymat = new int[][]{
        {-1,0,1},
        {2,-1,0},
        {-2,2,-1},
    };
    
    public static String Key = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public static void main(String[] args) {
        String text,outtext ="";
        int ch,n;
        ch = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter 1 To Encrypt and 2 to Decrypt"));
        text = JOptionPane.showInputDialog(null,"Enter plain/Cipher text:");
        text = text.toUpperCase();
        text = text.replaceAll("\\s", "");
        n = text.length() % 3;
        if(n!=0){
            for(int i = 1; i<=(3-n);i++){
                text+='X';
            }
        }
        System.out.println("Padded Text: " + text);
        char[] ptextchar = text.toCharArray();
        switch(ch){
            case 1:
                for(int i = 0;i<text.length();i+=3){
                    outtext += encrypt(ptextchar[i],ptextchar[i+1],ptextchar[i+2]);
                }
                break;
            case 2:
                for(int i=0;i<text.length();i+=3){
                    outtext += decrypt(ptextchar[i],ptextchar[i+1],ptextchar[i+2]);
                }
                break;
        }
        System.out.println("Output: " + outtext);
    }
    
    private static String encrypt(char a, char b, char c){
        String res="";
        int x,y,z;
        int posa = (int)a-65;
        int posb = (int)b-65;
        int posc = (int)c-65;
        x = posa*keymat[0][0]+posb*keymat[1][0]+posc*keymat[2][0];
        y = posa*keymat[0][1]+posb*keymat[1][1]+posc*keymat[2][1];
        z = posa*keymat[0][2]+posb*keymat[1][2]+posc*keymat[2][2];
        a = Key.charAt(x%26);
        b = Key.charAt(y%26);
        c = Key.charAt(z%26);
        res = "" + a + b + c;
        return res;                
    }
    private static String decrypt(char a, char b, char c){
        String res="";
        int x,y,z;
        int posa = (int)a-65;
        int posb = (int)b-65;
        int posc = (int)c-65;
        x = posa*invkeymat[0][0]+posb*invkeymat[1][0]+posc*invkeymat[2][0];
        y = posa*invkeymat[0][1]+posb*invkeymat[1][1]+posc*invkeymat[2][1];
        z = posa*invkeymat[0][2]+posb*invkeymat[1][2]+posc*invkeymat[2][2];
        a = Key.charAt((x%26<0)?(26+x%26):(x%26));
        b = Key.charAt((y%26<0)?(26+y%26):(y%26));
        c = Key.charAt((z%26<0)?(26+z%26):(z%26));
        res = "" + a + b + c;
        return res;                
    }
}
