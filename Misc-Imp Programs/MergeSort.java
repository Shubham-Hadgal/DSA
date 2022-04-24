
// Merge Sort Recursive

import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for(int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans[] = mergeSort(arr, 0, n-1);

        for(int i = 0 ; i < n; i++) {
            System.out.print(ans[i]+" ");
        }

        sc.close();

    }

    // fn to merge sort
    public static int[] mergeSort(int arr[], int s, int e) {

        if(e == s) {
            int ba[] = new int[1];
            ba[0] = arr[s];
            return ba;
        }

        // find mid
        int mid = (s+e) / 2;
        //get first half sorted
        int firstSortedHalf[] = mergeSort(arr, s, mid);
        //get second half sorted
        int secondSortedHalf[] = mergeSort(arr, mid+1, e);
        //get both fsa and ssa merged and return
        int fsa[] = mergeArray(firstSortedHalf, secondSortedHalf);

        return fsa;

    }

    // fn to merge two sorted arrays
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
