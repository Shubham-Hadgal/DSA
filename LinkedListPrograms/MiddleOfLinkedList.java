import java.util.Scanner;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        LinkedLists<Integer> list = new LinkedLists<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n > 0) {
            int data = sc.nextInt();
            list.addAtLast(data);
            n--;
        }

        Node<Integer> ans = middleOfLinkedList(list.getHeadPtr());
        System.out.println(ans.data);   
        sc.close();
    }

    private static Node<Integer> middleOfLinkedList(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        if(head.next == null || head.next.next == null) {
            return head;
        } else {
            while(fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
}
