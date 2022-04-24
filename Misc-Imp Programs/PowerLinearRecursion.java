
// Program to find power in linear time
// for eg: 2^3 = 8 
import java.util.*;

public class PowerLinearRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int ans = powerLiner(a,b);

        System.err.println(ans);
        sc.close();
    }

    private static int powerLiner(int a, int b) {
        if(b == 0) {
            return 1;
        }
        int ans = a * powerLiner(a, b-1);
        return ans;
    }
}
