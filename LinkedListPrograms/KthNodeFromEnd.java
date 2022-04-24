import java.util.Scanner;

// program to find kth Node from end of LinkedList
// cannot use size property
// solved by two pointer approach
public class KthNodeFromEnd {
    public static void main(String[] args) {
        LinkedLists<Integer> list = new LinkedLists<>();
        int n = 0;

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        while(n > 0) {
            int data = sc.nextInt();
            list.addAtLast(data);
            n--;
        }

        int k = sc.nextInt();

        Node<Integer> ans = kthNode(list, k);

        System.out.println(ans.data);
        
        sc.close();

    }

    private static Node<Integer> kthNode(LinkedLists<Integer> list, int k) {
        Node<Integer> slow = list.getHeadPtr();
        Node<Integer> fast = list.getHeadPtr();
        
        try {
            while(k > 0) {
                fast = fast.next;
                k--;
            }

            while(fast != list.getTailPtr()) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        } catch(Exception e) {
            System.out.println("Invalid args");
        }
        return null;
    }
}
