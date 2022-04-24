import java.util.HashMap;
import java.util.Map;

/* 
    The another version of this question is (Remove duplicates from sorted list)
    already solved on leetcode and code studio
*/

/// Program to remove duplicates from unsorted list

public class RemoveDuplicatesFromUnsortedList {
    public static void main(String[] args) {
        // create a linkedList (unsorted)
        LinkedLists<Integer> list = new LinkedLists<>();

        // Adding elements to LL -> i/p: 40 10 90 50 10 20 90 --> 
            // o/p: 40 10 90 50 20
        list.addAtLast(10);
        list.addAtLast(10);
        list.addAtLast(90);
        list.addAtLast(50);
        list.addAtLast(10);
        list.addAtLast(40);
        list.addAtLast(90);
        list.addAtLast(50);

        System.out.print("List before -> ");
        list.printList();

        // removing duplicates
        removeDuplicates(list);

        System.out.print("List after -> ");
        list.printList();

    }

    // Fn to remove duplicates from unsorted LL
    // TC -> O(n), SC -> O(n)
    private static void removeDuplicates(LinkedLists<Integer> list) {

        // Map that keeps a track of visited elements
        Map<Integer, Boolean> map = new HashMap<>();

        Node<Integer> prev = null;
        Node<Integer> cur = list.getHeadPtr();

        while(cur != null) {
            // if map contains cur element change prev next to further ptr
            if(map.containsKey(cur.data)) {
                prev.next = cur.next;
                cur = cur.next;
            } else { // else add cur data to map and itr to next node
                map.put(cur.data, true);
                prev = cur;
                cur = cur.next;
            }
        }
    }
}
