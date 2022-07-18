/*
 * Program to find element that appear once in an array other elements occurs twice
 * i/p: [4, 4, 2, 1, 1]
 * o/p: 2 (2 occurs once)
 * 
 ! size of an array is always (2m+1 -> odd)

 ! Algorithm -> Bit Manipulation Approach [T.C = O(n), S.C = O(1)]
    * using XOR property - when we xor two same number, that number gets cancelled or becomes 0

    1. create ans variable initialize it to 0
    2. traverse through array and XOR all elements until i < arr.length, eventually double elements will become 0, atlast only element will exist whose frequency was 1.
    3. return ans

 */

import java.util.Scanner;

public class FindTheElementThatAppearOnce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = findTheElementThatAppearOnce(arr);
        System.out.println(ans);
    }

    private static int findTheElementThatAppearOnce(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = ans^arr[i];
        }
        return ans;
    }
}