import java.util.*;

public class FindPivotElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = findPivot(arr);
        System.out.println(ans);
        sc.close();
    }

    private static int findPivot(int[] arr) {
        int i = 0; 
        int j = arr.length-1;

        while(i < j) {
            int mid = (i + j) / 2;

            if(arr[mid] <= arr[0]) {
                i = mid+1;
            } else {
                j = mid;
            }
        }
        return i;
    }
}
