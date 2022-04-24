public class DLLOperations {
    public static void main(String[] args) {
        
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        dll.addAtLast(10);
        dll.addAtLast(20);
        dll.addAtLast(30);
        dll.addAtLast(40);
        dll.addAtLast(50);

        dll.printListForward();
        System.out.println();
        dll.printListBackward();
        System.out.println();

        System.out.println(dll.getHead());
        System.out.println(dll.getTail());

        dll.removeHead();
        dll.removeTail();
        System.out.println(dll.size);
        dll.removeAt(1);
        System.out.println(dll.size);
        dll.printListForward();

    }
}