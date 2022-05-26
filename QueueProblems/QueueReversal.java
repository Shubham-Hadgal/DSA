// * Program to reverse the queue

/*
    !. Approach 1
    1. Create a stack and push queue elements to stack.
    2. Create output queue and add stack elements to queue and return queue.

    !. Approach 2
    * using recursion
        ! Algorithm
        1. base case i.e if queue is empty return empty queue.
        2. store front element of queue in variable x.
        3. recursive call for smaller problem (faith: it will reverse remaining queue.)
        4. just add x to rear of queue and return.
*/

public class QueueReversal {
    public static void main(String[] args) {
        Queues<Integer> q = new Queues<>();

        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);

        q.print();

        Queues<Integer> ans = reverseQueue(q);

        ans.print();

    }

    // method to reverse the Queue.
    private static Queues<Integer> reverseQueue(Queues<Integer> q) {

        // step 1
        if(q.isEmpty()) {
            return new Queues<>();
        }
        
        // step 2
        int x = q.front();
        q.remove();

        // step 3
        Queues<Integer> smallProb = reverseQueue(q);


        // step 4
        smallProb.add(x);

        return smallProb;

    }
}
