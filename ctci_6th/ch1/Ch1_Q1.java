//*******************************************************************
//  Chapter 1: Arrays and Strings
//  
//  Is Unique: Implement an algorithm to determine if a string has all unique
//             characters. What if you cannot use additional data structures?
//*******************************************************************
import java.util.*;

public class Ch1_Q1 {

    static boolean uniqueStatus(String str) {
        if (str.equals("")) {
            return true;
        }

        int bits = 0;

        for (char c: str.toCharArray()) {
            int char_val = Character.getNumericValue(c)
                           - Character.getNumericValue('a');

            if ((bits & (1 << char_val)) > 0) {
                return false;
            } else {
                bits = bits | (1 << char_val);
            }

        }
        return true;
    }

    public static void main(String[] args) {
        boolean j = uniqueStatus("");

        System.out.println(j);
    }

}