/* 
    Java program to interleave
    the first half of the queue
    with the second half

    Input : 11 12 13 14 15 - 16 17 18 19 20
    Output : 11 16 12 17 13 18 14 19 15 20

    ! Algorithm
    1. create stack and push first half into stack
    2. push stack element into back of the queue
    3. push starting queue elements to back of the queue(first half)
    4. again push First half into the stack.
    5. interleave the elements of queue and stack

*/

import java.util.*;

public class InterLeaveTheFirstHalfWithSecondHalfOfQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> q = new LinkedList<>();

        int n = sc.nextInt();

        while(n > 0) {
            int x = sc.nextInt();
            q.offer(x);
            n--;
        }

        Queue<Integer> ans = interLeaveQueue(q);
        System.out.println(ans);
        sc.close();
    }

    private static Queue<Integer> interLeaveQueue(Queue<Integer> q) {
        // get half of queue
        int half = q.size()/2;

        // Initialize an empty stack of int type
        Stack<Integer> st = new Stack<>();

        // Push first half elements into the stack
        // queue:16 17 18 19 20, stack: 15(T) 14 13 12 11
        while(half > 0) {
            st.push(q.poll());
            half--;
        }

        // enqueue back the stack elements
        // queue: 16 17 18 19 20 - 15 14 13 12 11
        while(!st.isEmpty()) {
            q.offer(st.pop());
        }

        half = q.size()/2;

        // dequeue the first half elements of queue
        // and enqueue them back
        // queue: 15 14 13 12 11 - 16 17 18 19 20
        while(half > 0) {
            q.offer(q.poll());
            half--;
        }

        half = q.size()/2;

        // Again push the first half elements into the stack
        // queue: 16 17 18 19 20, stack: 11(T) 12 13 14 15
        while(half > 0) {
            st.push(q.poll());
            half--;
        }

        // interleave the elements of queue and stack
        // queue: 11 16 12 17 13 18 14 19 15 20
        while(!st.isEmpty()) {
            int first = st.pop();
            int sec = q.poll();

            q.offer(first);
            q.offer(sec);
        }
        return q;
    }
}
