//*******************************************************************
//  Chapter 1: Arrays and Strings
//  
//  Palindrome Permutation: 
//  Given a string, write a function to check if it is a permutation
//  of a palindrome. A palindrome is a word or phrase that is the
//  same forwards and backwards. A permutation is a rearrangement of
//  letters. The palindrome does not need to be limited to just
//  dictionary words.      
//*******************************************************************
import java.util.*;

public class Ch1_Q4 {

    public static boolean isPerm(String str) {
        if (str.length() == 0) {
            return true;
        }

        char[] s = str.toLowerCase().toCharArray();
        int bit_check = 0;
        int len = 0;

        for (char c: s) {
            if (c != ' ') {
                len++;
                int char_bit = Character.getNumericValue(c)
                               - Character.getNumericValue('a');
                bit_check ^= 1 << char_bit;
            }
        }

        if (len % 2 == 0) {
            if (bit_check == 0) {
                return true;
            } else {
                return false;
            }
        } else if (len % 2 == 1) {
            if (((bit_check - 1) & bit_check) == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }

    }

    public static void main(String[] args) {
        System.out.println(isPerm("Tact Coa"));
        System.out.println(isPerm("hhuueeooaah"));
        System.out.println(isPerm("h o e un nh o e "));
        System.out.println(isPerm("rchrchrch"));
        System.out.println(isPerm("      "));
        System.out.println(isPerm(""));
        System.out.println(isPerm("TACDHtacdh"));
        System.out.println(isPerm("h"));
        System.out.println(isPerm("h r c e o k r"));
        System.out.println(isPerm("hhhhhhhhhhhhhhhhhhhhhhh"));
        /*
            true
            true
            true
            false
            true
            true
            true
            true
            false
            true
        */
    }
}