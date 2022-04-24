// Program to return index of last occurenec of element

// for rg: 22 6 1 88 9 (1) -> 2

import java.util.*;

public class RecLastOccurenceIdx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = maxInArray(arr, 0, 1);
        System.out.println(ans);

        sc.close();
    }

    private static int maxInArray(int[] arr, int idx, int x) {

        // base case
        if(idx == arr.length) {
            return -1;
        }
        
        // this returns last occurence of element if found int idx from 1 to arr.length
        int sans = maxInArray(arr, idx + 1, x);

        // compare it with 0th idx
        if(sans == -1) {
            if(arr[idx] == x) {
                return idx;
            }
            else {
                return -1;
            }
        }
        else {
            return sans;
        }
    }
}
