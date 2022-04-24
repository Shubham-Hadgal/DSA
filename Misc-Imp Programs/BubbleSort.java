// Program to sort array Using BubbleSort algo

// for eg: in every itr Largest element is place to its correct position.

import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        bubbleSort(arr, n);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }

        sc.close();
        
    }

    public static void bubbleSort(int arr[], int n) {
        if(n == 0 || n == 1) {
            return;
        }

        for(int i = 0 ; i < n-1; i++) {
            if(arr[i] > arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        bubbleSort(arr, n-1);
    }
}
