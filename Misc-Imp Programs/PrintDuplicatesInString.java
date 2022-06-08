/*
 *  Print all the duplicates in the input string

    ! Algorithm

    1. Create an array for hashing, map charater with array idx i.e 
            0 = a, 1 = b using (character-97 or 65);

    2. traverse through ip string and increase arr[s.charAt(i)-97] by 1;
    3. traverse through arr and print idx+97 = count;
    
        ! arr can be smallCharHash as well as CapCharHash.
 */

import java.util.*;

public class PrintDuplicatesInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        findDuplicates(s);
        sc.close();
    }

    // method to print duplicates
    private static void findDuplicates(String s) {
        // creating array map.
        int smallHash[] = new int[26]; // small letters
        int capHash[] = new int[26]; // capital letters

        // processing ip string and storing count of chars
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                smallHash[s.charAt(i) - 97]++;
            }
            else {
                capHash[s.charAt(i) - 65]++;
            }
        }

        // traversing smallHash
        for(int i = 0; i < 26; i++) {
            if(smallHash[i] > 1) {
                System.out.println((char)(i+97)+" -> "+ smallHash[i]);
            }
        }

        // traversing capHash
        for(int i = 0; i < 26; i++) {
            if(capHash[i] > 1) {
                System.out.println((char)i+65+" -> "+ capHash[i]);
            }
        }
        
    }
}
