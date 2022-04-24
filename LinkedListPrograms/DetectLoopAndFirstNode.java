/*
    This Program does multiple task
    1. detects loop in LL  (Floyds cycle detection algorithm)
    2. return a node where loop begins (uses FCD and simple maths)
    3. removes loop from LL (can be used after finding beginning node of loop, step1 and step2)
*/

public class DetectLoopAndFirstNode {

    // Creating Linkedlist
    static LinkedLists<Integer> list = null;
    static Node<Integer> slow = null;
    static Node<Integer> fast = null;
    public static void main(String[] args) {

        // adding elments in LL
        list = new LinkedLists<>();
        list.addAtLast(20);
        list.addAtLast(10);
        list.addAtLast(33);
        list.addAtLast(4);
        list.addAtLast(99);
        list.addAtLast(63);
        list.addAtLast(21);
        list.addAtLast(89);
        slow = list.getHeadPtr();
        fast = list.getHeadPtr();


        // System.out.println(list.getHeadPtr().data);
        // System.out.println(list.getTailPtr().data);

        // adding loop to the list (0 indexed)
        int k = 4; // index where loop connects
        addLoop(k);

        boolean ans = detectLoop();
        // System.out.println(ans);

        // if there's a loop do the following
        if(ans) {
            System.out.println("Loop is detected.");
            Node<Integer> startNode = getLoopFirstNode();
            System.out.println("Loop starts at -> " + startNode.data);
        } else{
            System.out.println("No loop detected");
        }

        // removing loop in LL
        removeLoop();

        System.out.println("List after removing loop -> ");
        list.printList();

    }
    
    // This Fn removes loop from LL
    private static void removeLoop() {
        while(slow.next != fast) {
            slow = slow.next;
        }

        slow.next = null;
    }

    // this Fn return first node where the loop start

    /*      0 indexing based

        1->89->2->11->4->34->23->10->
                         ^          |
                         |__________|
    */
    private static Node<Integer> getLoopFirstNode() {
        fast = list.getHeadPtr();
        while(slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    // this fn return true if loop is detected else return false
    private static boolean detectLoop() {
   
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

    // Function to Add loop in LL
    private static void addLoop(int k) {
        Node<Integer> ptr = list.getHeadPtr();
        // System.out.println(ptr.data);
        while(k > 0) {
            ptr = ptr.next;
            k--;
        }

        // changing tail node.next to ptr to create a loop
        Node<Integer> tnNode = list.getTailPtr();
        tnNode.next = ptr;
    }
}
