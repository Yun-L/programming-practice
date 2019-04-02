//*******************************************************************
//  Chapter 1: Arrays and Strings
//  
//  URLify: Write a method to replace all spaces in a string with '%20'
//          You may assume that the string has sufficient space at the
//          end to hold the additional characters, and that you are
//          given the "true" length of the string.
//*******************************************************************
import java.util.*;

public class Ch1_Q3 {

    public static String url(String s, int len) {
        char[] sc = s.toCharArray();
        boolean filler = true;
        int marker = s.length() - 1;

        for (int i = len - 1; i >= 0; i--) {
            if (sc[i] != ' ') {
                filler = true;
            }
            if (filler == true) {
                if (sc[i] == ' ') {
                    space(marker, sc);
                    marker -= 3;
                } else {
                    sc[marker] = sc[i];
                    marker -= 1;
                }
            }
        }

        return String.valueOf(sc);
    }

    private static void space(int marker, char[] sc) {
        sc[marker] = '0';
        sc[marker-1] = '2';
        sc[marker-2] = '%';
    }

    public static void main(String[] args) {
        System.out.println((url("  hicehoor rc      ", 13)));
        System.out.println((url("mr John Smith    ", 13)));
        System.out.println((url(" h h h h h h            ", 12)));
        System.out.println((url("rchu    rhh        ", 11)));
        System.out.println((url("", 0)));
        System.out.println((url("u", 1)));
        System.out.println((url("     ", 0)));
        //check length to ensure no extra trailing spaces
        System.out.println((url("  hicehoor rc      ", 13).length()));
        System.out.println((url("mr John Smith    ", 13).length()));
        System.out.println((url(" h h h h h h            ", 12).length()));
        System.out.println((url("rchu    rhh        ", 11).length()));
        System.out.println((url("", 0).length()));
        System.out.println((url("u", 1).length()));
        System.out.println((url("     ", 0).length()));
    }
}