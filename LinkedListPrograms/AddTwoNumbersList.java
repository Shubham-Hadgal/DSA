/*
    This Program Adds two List 

    list1 -> 1 2 3
    list2 -> 5 2 4
             | | |
    o/p - >  6 4 7

     Algorithm : 1. Reverse LinkedList
                 2. Add Two LinkedList
                 3. Reverse Answer List and return 
*/

public class AddTwoNumbersList {
    public static void main(String[] args) {
        // Creating LinkedList 1
        LinkedLists<Integer> list1 = new LinkedLists<>();
        list1.addAtLast(9);
        list1.addAtLast(5);
        list1.addAtLast(7);
        list1.addAtLast(5);

        // Creating LinkedList 2
        LinkedLists<Integer> list2 = new LinkedLists<>();
        list2.addAtLast(1);
        list2.addAtLast(0);
        list2.addAtLast(5);

        // list1.printList();
        // list2.printList();

        Node<Integer> answer = addLinkedlists(list1.getHeadPtr(), list2.getHeadPtr());


        // Printing the answer
        System.out.println("Answer List");
        while(answer != null) {
            System.out.print(answer.data+" ");
            answer = answer.next;
        }
    }

    // Fn to add 2 LL
    private static Node<Integer> addLinkedlists(Node<Integer> first, Node<Integer> second) {
        
        // Step 1: Reverse Both LinkedList
        Node<Integer> list1Head = reverse(first);
        Node<Integer> list2Head = reverse(second);

        // Step 2: Add Reversed Lists
        Node<Integer> ans = add(list1Head, list2Head);

        // Step 3: Reverse the Answer List
        Node<Integer> finalAns = reverse(ans);

        return finalAns;
    }

    // Fn to add two elements and Carry(if available) of LL 
    private static Node<Integer> add(Node<Integer> list1Head, Node<Integer> list2Head) {

        int carry = 0;
        LinkedLists<Integer> list = new LinkedLists<>();

        while(list1Head != null || list2Head != null || carry != 0) {

            int val1 = 0;
            if(list1Head != null) {
                val1 = list1Head.data;
            }

            int val2 = 0;
            if(list2Head != null) {
                val2 = list2Head.data;
            }

            int sum = carry + val1 + val2;

            int digit = sum % 10;

            list.addAtLast(digit);
            carry = sum / 10;

            if(list1Head != null) list1Head = list1Head.next;

            if(list2Head != null) list2Head = list2Head.next;
        }

        return list.getHeadPtr();
        
    }

    // Fn to Reverse the LL
    private static Node<Integer> reverse(Node<Integer> head) {

        // if LL has only 1 Node
        if(head == null) {
            return head;
        }

        Node<Integer> prev = null;
        Node<Integer> cur = head;
        Node<Integer> fwd = head.next;

        while(cur != null) {
            cur.next = prev;
            prev = cur;
            cur = fwd;
            if(fwd != null) {
                fwd = fwd.next;
            }
        }
        return prev;

    }
}
