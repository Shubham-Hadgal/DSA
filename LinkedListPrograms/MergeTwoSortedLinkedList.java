/*
    Program to merge two sorted LL

    Algorithm : Check for such element from second list that can be inserted into first list
                such that (l1.data <= element <= l1.next .data)
*/

public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {
        // Creating first LL
        LinkedLists<Integer> list1 = new LinkedLists<>();

        list1.addAtLast(7);
        list1.addAtLast(8);

        // Creating second LL
        LinkedLists<Integer> list2 = new LinkedLists<>();

        list2.addAtLast(1);
        list2.addAtLast(3);
        list2.addAtLast(4);
        list2.addAtLast(6);

        Node<Integer> node = mergeLists(list1.getHeadPtr(), list2.getHeadPtr());

        while(node != null) {
            System.out.print(node.data+" ");
            node  = node.next;
        }
        
    }

    private static Node<Integer> mergeLists(Node<Integer> head1, Node<Integer> head2) {

        // if one of the list in empty return opponent list
        if(head1 == null) {
            return head2;
        } else if(head2 == null) {
            return head1;
        }
    
        // pass the list to method to merge according its head value
            // if(l1.head < l2.head) -> head1 list will be first list
            // else if(l1.head > l2.head) -> head2 will be first list
        if(head1.data <= head2.data) {
            Node<Integer> node = solve(head1, head2);
            return node;
        } else {
            Node<Integer> node = solve(head2, head1);
            return node;
        }
    }

    // Fn that merges two sorted list
    private static Node<Integer> solve(Node<Integer> head1, Node<Integer> head2) {

        if(head1.next == null) {
            head1.next = head2;
            return head1;
        }
        Node<Integer> curr1 = head1;
        Node<Integer> curr2 = head2;

        Node<Integer> n1 = head1.next;
        Node<Integer> n2 = head2.next;

        /*
            Check for such element from second list that can be inserted into first list
                such that (l1.data <= element <= l1.next .data)
        */

        while(n1 != null && curr2 != null) {
            if(curr2.data >= curr1.data && curr2.data <= n1.data) {
                curr1.next = curr2;
                n2 = curr2.next;
                curr2.next = n1;
                
                curr1 = curr2; 
                curr2 = n2;
            } else {
                curr1 = n1;
                n1 = n1.next;
                if(n1 == null) {
                    curr1.next = curr2;
                    return head1;
                }
            }
        }
        return head1;
    }
}