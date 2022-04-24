/*
    Program to find if LinkedList is palindrome or not

    i/p: 1 2 3 3 2 1 ------ o/p: true

    Algorithm :- 1. Find Mid of LL  -> 1 2 3 (3) 2 1
                 2. Reverse the second half of LL (from mid to tail) -> 1 2 3 (1 2 3)
                 3. compare both LL from head to Tail -> all values are same so ITC return true.
                 
*/

public class PalindromeLinkedList {
    public static void main(String[] args) {
        // Creating Linked List

        LinkedLists<Integer> list = new LinkedLists<>();

        list.addAtLast(1);
        list.addAtLast(2);
        list.addAtLast(3);
        list.addAtLast(3);
        list.addAtLast(2);
        list.addAtLast(1);

        // checking palindrom of LL 

        boolean ans = isPalindrome(list.getHeadPtr()); // return boolean

        // Print ans
        System.out.println(ans);

    }

    // This Fn checks if list is Palindrome

    private static boolean isPalindrome(Node<Integer> head) {
        
        // Find Mid of LL
        Node<Integer> mid = findMid(head);

        // Reverse the LL from mid to end ---- 1 2 3 (3 2 1) inBrace gets reversed
        Node<Integer> reverseMid = reverse(mid);

        // now we have two LL -> h1 - 1 2 3, h2 - 1 2 3
        // compare both LL from head to tail if data is differnt return false else true 
        Node<Integer> temp1 = head;
        Node<Integer> temp2 = reverseMid;
        while(temp2 != null) {
            if(temp1.data.equals( temp2.data)) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else {
                return false;
            }
        }
        return true;
    }

    // This Fn Returns the ptr to half reversed LL
    /*
        i/p : 1 2 3 (3 2 1) ---- o/p : (1 2 3) passed mid of LL as param
    */
    private static Node<Integer> reverse(Node<Integer> mid) {
        Node<Integer> prev = null;
        Node<Integer> cur = mid;
        Node<Integer> fwd = mid.next;

        cur.next = null;

        while(fwd != null) {
            prev = cur;
            cur = fwd;
            fwd = fwd.next;
            cur.next = prev;
        }

        return cur;
    }
    /*                                   
                    m = mid                  m
    This Fn returns Mid ptr to LL        1 2 3 4 5 
    */
    private static Node<Integer> findMid(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast == null) {
            return slow;
        } else {
            return slow.next;
        }
    }
}