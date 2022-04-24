/*
    DOUBLY LINKED LIST

    This Class has Following Methods

    1. AddAtLast : Adds element at end of the list.
    2. AddAtFront : Adds Element at start of the list.
    3. printForward : prints list from start to end.
    4. printbackward : prints list form end to start.
    5. getHead : returns head element.
    6. getTail : returns tail Element.
    7. setTail : sets the Tail pointer
    8. setHead : sets the Head Pointer.
    9. removeHead : removes head Node.
    10. removeTail : removes Tail Node.
    11. removeAt : removes the Node at specific position.
*/
public class DoublyLinkedList<T> {

    // Properties of DLL
    int size;
    private DNode<T> head;
    private DNode<T> tail;

    // Constructor
    DoublyLinkedList() {
        size = 0;
        setHead(null);
        setTail(null);
    }

    // returns tailNode
    public DNode<T> getTail() {
        if(tail != null) {
            return tail;
        } else {
            return null;
        }
    }

    // sets the tail
    public void setTail(DNode<T> tail) {
        this.tail = tail;
    }

    // return headNode
    public DNode<T> getHead() {
        if(head != null) {
            return head;
        } else {
            return null;
        }
    }

    // sets the head
    public void setHead(DNode<T> head) {
        this.head = head;
    }

    // method to add element at last.
    public void addAtLast(T val) {
        DNode<T> newNode = new DNode<>(val);
        
        // Edge Case if LL is Empty.
        if(tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // method to Add element at front.
    public void addAtFront(T val) {
        DNode<T> newNode = new DNode<>(val);

        // Edge case if LL is empty i.e head == null
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Method to print List from start to end
    public void printListForward() {
        DNode<T> temp = head; // traversing pointer

        // Exception if list is empty
        if(temp == null) {
            System.out.println("Empty!");
            return;
        } else {
            while(temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
    }

    // Method to print list from end to start
    public void printListBackward() {
        DNode<T> temp = tail; // traversing pointer

        // Exception if list is empty
        if(temp == null) {
            System.out.println("Empty!");
            return;
        } else {
            while(temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.prev;
            }
        }
    }

    // method to remove head Node
    public void removeHead() {
        if(head != null) {
            head = head.next;
            head.prev = null;
            size--;
        } else {
            System.out.println("Empty!");
        }
    }

    // method to remove tail Node
    public T removeTail() {
        if(tail != null) {
            T x = tail.data;
            tail = tail.prev;
            if(tail != null) {
                tail.next = null;
            }
            size--;
            return x;
        } else {
            System.out.println("Empty!");
            return null;
        }
    }

    // method to Node at specific position (0 based indexing)
    public void removeAt(int i) {

        // check if index is in the bound
        if(i < 0 || i >= size) {
            System.out.println("Invalid Index");
            return;
        }
        DNode<T> temp = head;
        if(temp != null) {
            if(i == 0) { // first element
                removeHead();
            } else if(i == size-1) { // last element
                removeTail();
            } else {
                while(i > 0) {
                    temp = temp.next;
                    i--;
                }
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
            size--;
        } else {
            System.out.println("Empty!");
        }
    }
}
