
// fn used to partition array between pivot element
// for eg: if pivot is 3 all the elements <= 3 is shifted to left part of   array
// if pivot is 3 all the elements > 3 is shifted to right part of array

import java.util.*;

public class PartioningAnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for(int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        partionArray(arr, 20);

        for(int i = 0 ; i < n; i++) {
            System.out.print(arr[i]+" ");
        }

        sc.close();
    }

    public static void partionArray(int[] arr, int pivot) {
        int i = 0;
        int j = 0;

        while(j < arr.length) {
            if(arr[j] > pivot) {
                j++;
            }
            else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j++;
            }
        }
    }
}
