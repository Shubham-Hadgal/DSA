import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for(int i = 0 ; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, n-1);

        for(int i = 0 ; i < n; i++) {
            System.out.print(arr[i]+" ");
        }

        sc.close();
    }

    //quick sort fn
    private static void quickSort(int[] arr, int s, int e) {

        if(s >= e) {
            return ;
        }

        int pivot = arr[e];
        int idx = partionArray(arr, pivot, s, e);

        quickSort(arr, s, idx-1);
        quickSort(arr, idx+1, e);
    }

    // fn used to partition array between pivot element
    // for eg: if pivot is 3 all the elements <= 3 is shifted to left part of array
    // if pivot is 3 all the elements > 3 is shifted to right part of array
    public static int partionArray(int[] arr, int pivot, int s, int e) {
        int i = s;
        int j = s;

        while(i <= e) {
            if(arr[i] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j++;
            }
            else {
                i++;
            }
        }
        return (j-1);
    }

}
