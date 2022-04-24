// Program to merge two sorted arrays
// for eg: arr1 = 2 5 12 18 20, arr2 = 7 9 11 15 25 28 30 35
// both arrays merged in sorted manner
// then ans = 2 5 7 9 11 12 15 18 20 25 30 35
// Two Pointers Approach

import java.util.*;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // First array  2 5 12 18 20
        int n1 = sc.nextInt();
        int arr1[] = new int[n1];
        for(int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        // Second array  7 9 11 15 25 28 30 35
        int n2 = sc.nextInt();
        int arr2[] = new int[n2];
        for(int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        int ans[] = mergeArray(arr1, arr2);

        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }

        sc.close();
    }

    public static int[] mergeArray(int arr1[], int arr2[]) {

        if(arr1.length == 0) {
            return arr2;
        }
        else if(arr2.length == 0) {
            return arr1;
        }

        // new array to which will store merged values
        int arr[] = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] <= arr2[j]) {
                arr[k++] = arr1[i++];       //  2 5 12 18 20
            }
            else {
                arr[k++] = arr2[j++];       //  7 9 11 15 25 28 30 35
            }
        }

        while(i < arr1.length) {
            arr[k++] = arr1[i++];
        }

        while(j < arr2.length) {
            arr[k++] = arr2[j++];
        }
        
        return arr;

    }
}
