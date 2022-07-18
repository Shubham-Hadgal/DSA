/*
    Program to swap alternate elements in array
    i/p: [1,2,3,4,5]
    o/p: [2,1,4,3,5]

    ! Algorithm
    1. create two pointers at index 0 and 1
    2. swap both elements
    3. increment ptr1 and ptr2 by 2 index
    4. repeat the step 2 until ptr2 < arr.length
*/

import java.util.Scanner;

public class SwapAlternateInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        swapAlternate(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }

    private static void swapAlternate(int[] arr) {

        // step 1
        int ptr1 = 0;
        int ptr2 = 1;

        //step 2, 3 and 4
        while (ptr2 < arr.length) {
            int temp = arr[ptr1];
            arr[ptr1] = arr[ptr2];
            arr[ptr2] = temp;

            ptr1 = ptr1 + 2;
            ptr2 = ptr2 + 2;
        }
    }
}
