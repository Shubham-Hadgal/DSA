public class MoveAllNegativeElementsAtStarting {
    public static void main(String[] args) {
        int arr[] = {-98,23,-9,6,-67,-5,2,-2};

        moveElements(arr);

        for(int i = 0; i  < arr.length; i++) {
            System.out.print(arr[i] +" ");
        }
    }

    private static void moveElements(int[] arr) {
        int i = 0;
        int j = 0;

        while(j < arr.length) {
            if(arr[j] < 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            } else {
                j++;
            }
        }
    }
}