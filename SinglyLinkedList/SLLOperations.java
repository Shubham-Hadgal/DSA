public class SLLOperations {
    public static void main(String[] args) {

        // Creating LinkedList
        LinkedLists<Integer> list = new LinkedLists<>();

        // Adding data to LinkedList 
        list.addAtLast(10);
        list.addAtLast(20);
        list.addAtLast(30);
        list.addAtLast(23);
        list.addAtLast(40);
        list.addAtLast(50);
        list.addAtLast(100);

        // Printing LinkedList
        list.printList();

        // Prinnting Size of LinkedList
        System.out.println("Size of list is -> " + list.size);
        //Printing head and tail of LinkedList
        System.out.println("Head -> " + list.getFirst());
        System.out.println("Tail -> " + list.getLast());
        
        // Removing from first
        list.removeFirst();
        // list.removeFirst();

        // Printing LinkedList
        list.printList();

        // Printing Size of LinkedList
        System.out.println("Size of list is -> " + list.size);
        //Printing head and tail of LinkedList
        System.out.println("Head -> " + list.getFirst());
        System.out.println("Tail -> " + list.getLast());

        // Printing list data at particular index
        System.out.println("At idx 0 -> " + list.atIndex(0));

        // adding data at first position
        list.addFirst(15);
        list.printList();

        // removing last data
        list.removeLast();
        list.printList();

        //reversing the linked list

        //Printing head and tail of LinkedList
        System.out.println("Head -> " + list.getFirst());
        System.out.println("Tail -> " + list.getLast());

        list.reverse();

        //Printing head and tail of LinkedList
        System.out.println("Head -> " + list.getFirst());
        System.out.println("Tail -> " + list.getLast());
        list.printList();

        list.removeAt(2);
        list.printList();

        
    }
}
