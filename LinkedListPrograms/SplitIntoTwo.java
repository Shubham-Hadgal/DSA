/*
    Program to split the circular LL in two halfs
*/

// class that holds two Node ptrs
class TwoNodes {
    Node<Integer> n1;
    Node<Integer> n2;

    TwoNodes(Node<Integer> n1, Node<Integer> n2) {
        this.n1 = n1;
        this.n2 = n2;
    }
}

public class SplitIntoTwo {

    public static void main(String[] args) {

        // creating LL
        LinkedLists<Integer> list = new LinkedLists<>();

        list.addAtLast(1);
        list.addAtLast(2);
        list.addAtLast(3);
        list.addAtLast(4);
        list.addAtLast(5);

        //changing tail.next to head i.e making LL circular
        list.getTailPtr().next = list.getHeadPtr();

        // splitting LL into two halfs
        TwoNodes ans = splitLinkedList(list);

        // tarversing n1
        Node<Integer> temp = ans.n1;

        System.out.print("List 1 -> ");
        while(temp.next != ans.n1) {
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
        System.out.print(temp.data);

        System.out.println();

        // traversing n2
        temp = ans.n2;
        System.out.print("List 2 -> ");
        while(temp.next != ans.n2) {
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }

    private static TwoNodes splitLinkedList(LinkedLists<Integer> list) {
        
        // breaking the Loop
        breakLoop(list);

        // Getting mid of LL using slow and fast ptrs
        Node<Integer> slow = list.getHeadPtr();
        Node<Integer> fast = list.getHeadPtr();
        Node<Integer> prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // generating to heads for two LL and breaking LL into two halfs
        Node<Integer> head1, head2 = null;
        head1 = list.getHeadPtr();
        head2 = slow;

        // prev.next = null;

        prev.next = head1;

        Node<Integer> tempNode = head2;
        while(tempNode.next != null) {
            tempNode = tempNode.next;
        }

        tempNode.next = head2;

        // adding both head ptrs to ans
        TwoNodes ans = new TwoNodes(head1, head2);

        return ans;

    }

    private static void breakLoop(LinkedLists<Integer> list) {

        // loop break method
        Node<Integer> temp = list.getHeadPtr();
        while(temp.next != list.getHeadPtr()) {
            temp = temp.next;
        }
        temp.next = null;
    }
}
