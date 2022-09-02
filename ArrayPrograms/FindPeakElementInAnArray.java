/*
 * Peak element is element that is greater than its left and right element
 * i/p:  23 32 34 56 23 17 15 10 6
 *                |
 *              Peak Element =  left < 56 > right
 * 
    ! Algorithm
    1. Using binary search
    == While i < j
        2. if(left < mid > right) than return mid
        3. if(mid < mid+1) i = i + 1;
        4. else j = mid
 */

import java.util.Scanner;

public class FindPeakElementInAnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = findPeakElement(arr);
        System.out.println(ans);

        sc.close();
    }

    private static int findPeakElement(int[] arr) {

        if(arr.length == 1) {
            return 0;
        } else if(arr.length == 2) {
            if(arr[0] > arr[1]) {
                return 0;
            } else {
                return 1;
            }
        }
        int i = 0;
        int j = arr.length-1;

        while(i < j) {
            int mid = (i+j)/2;

            if(arr[mid] < arr[mid+1]) {
                i = mid+1;
            } else {
                j = mid;
            }
        }
        return i;
    }
}
