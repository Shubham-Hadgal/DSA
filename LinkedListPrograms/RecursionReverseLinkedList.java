
public class RecursionReverseLinkedList {

    static LinkedLists<Integer> linkedLists = new LinkedLists<>();
    public static void main(String[] args) {
        

        linkedLists.addAtLast(10);
        linkedLists.addAtLast(20);
        linkedLists.addAtLast(30);
        linkedLists.addAtLast(40);
        linkedLists.addAtLast(50);
        linkedLists.addAtLast(60);
        linkedLists.addAtLast(70);


        System.out.print("Before reverse -> ");
        linkedLists.printList();

        reverseLinkedList(linkedLists.getHeadPtr());
        
        System.out.print("After reverse -> ");
        linkedLists.printList();
        
    }

    static void reverseLinkedList(Node<Integer> head) {
        reverse(head);

        head.next = null;
        Node<Integer> temp = head;
        linkedLists.setHead(linkedLists.getTailPtr());
        linkedLists.setTail(temp);

    }

    static void reverse(Node<Integer> node) {
        if(node == null) {
            return;
        }
        reverse(node.next);
        if(node == linkedLists.getTailPtr()) {
            // nothing to do
        } else {
            node.next.next = node;
        }
    }

}