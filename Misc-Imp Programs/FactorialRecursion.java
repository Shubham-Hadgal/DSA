// Program to find factorial of n Recursively 
// for eg: fact(5) = 5*4*3*2*1 = 120;

import java.util.*;

public class FactorialRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int ans = factorial(n);
        System.out.println(ans);
        sc.close();
    }

    // valid for every recursive Problem
    //              |
    // Expectation = Fact(n->5) = 120;
    // Recursive Leap Of Faith(Works on Smaller Problem) = Fact(n-1 -> 4) = 24 (4*3*2*1)

    // Relation bewtween expectation and faith = n->5 * fact(n-1 -> 4) = 120 (answer).

    private static int factorial(int n) {

        // base case
        if(n == 0) {
            return 1;
        }

        //recursive call
        return n * factorial(n-1);
    }
}
