/*
    This is a STACK Class implemented using DOUBLY LINKED LIST

    ! Default size of stack is = 100

    * Methods : 
    1. push()
    2. pop()
    3. isEmpty().
    4. peek().
    5. size();
    6. printStack().
*/

class Stacks<T> {
    DNode<T> top;
    private DoublyLinkedList<T> dll;
    private int totalSize = 100;
    private int currentSize;

    // Default Constructor
    Stacks() {
        dll = new DoublyLinkedList<>();
        top = dll.getHead();
        currentSize = 0;
    }

    // param Constructor takes size
    Stacks(int val) {
        dll = new DoublyLinkedList<>();
        top = dll.getHead();
        totalSize = val;
        currentSize = 0;
    }


    // Method to push element in stack. 
    void push(T val) {
        if(currentSize < totalSize) {
            dll.addAtLast(val);
            currentSize++;
            top = dll.getTail();
        } else {
            System.out.println("OverFlow element: "+val);
        }
    }


    // method to pop element is stack.
    T pop() {
        if(currentSize > 0) {
            T x = dll.removeTail();
            currentSize--;
            top = dll.getTail();
            return x;
        } else {
            System.out.println("UnderFlow");
            return null;
        }
    }

    // method to peek element in stack
    T peek() {
        if(currentSize > 0 && currentSize <= totalSize) {
            return dll.getTail().data;
        } else {
            System.out.println("Stack is Empty");
            return null;
        }
    }


    // method to print stack
    void printStack() {
        DNode<T> temp = dll.getTail();
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.prev;
        }
        System.out.println();
    }


    // return true or false if stack is empty or not
    boolean isEmpty() {
        return currentSize == 0 ? true : false;
    }


    // returns size of stack
    int size() {
        return currentSize;
    }
}