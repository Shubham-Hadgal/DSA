import java.util.*;

public class Temp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Long> arr = new ArrayList<>();

        for(int i = 0 ; i < n; i++) {
            arr.add(sc.nextLong());
        }

        int n2 = sc.nextInt();
        List<Long> eat = new ArrayList<>();

        for(int i = 0 ; i < n2; i++) {
            eat.add(sc.nextLong());
        }

        long ans = findMax(arr, eat);
        System.out.println(ans);
        sc.close();
    }

    public static long findMax(List<Long> arr, List<Long> eat) {
        long max = Integer.MIN_VALUE;

        for(int i = 0 ; i < arr.size(); i++) {
            if(arr.get(i) + eat.get(i) > max) {
                max = arr.get(i) + eat.get(i);
            }
        }
        return max;
    }
}
