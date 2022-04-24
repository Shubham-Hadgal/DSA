// Linked List Class

public class LinkedLists<T> { 
    private Node<T> head;
    private Node<T> tail;
    int size;

    public LinkedLists() {
        head = null;
        tail = null;
        size = 0;
    }

    // Function that adds data tail
    void addAtLast(T data) {
        Node<T> temp = head;

        if(temp == null) {
            Node<T> node = new Node<T>(data);
            head = node;
            tail = node;
        }
        else {
            while(temp.next != null) {
                temp = temp.next;
            }

            Node<T> node = new Node<T>(data);
            temp.next = node;
            tail = node;
        }
        size++;
    }


    // Function to remove head data
    void removeFirst() {
        if(head == null) {
            System.out.println("Head is empty");
            return;
        }
        else if(head == tail) {
            head = null;
            tail = null;
        }
        else if(head.next == null) {
            head = null;
            tail = null;
            size--;
        }
        else {
            Node<T> temp = head;
            head = head.next;
            temp.next = null;
            size--;
        }
        
    }


    // Function that return head data
    T getFirst() {
        if(head == null) {
            System.out.println("Head is empty");
            return null;
        }
        else {
            return head.data;
        }
    }

    // Function that return tail data
    T getLast() {

        if(tail == null) {
            System.out.println("Tail is empty");
            return null;
        } else {
            return tail.data;
        }
    }


    // Function to add data at paritcular index
    T atIndex(int idx) {
        if(head == null) {
            System.out.println("Head is empty");
            return null;
        } else if (tail == null) {
            System.out.println("Tail is empty");
            return null;
        }

        if(idx >= size) {
            System.out.println("Inavlid index");
            return null;
        }

        Node<T> temp = head;
        while(idx > 0) {
            temp = temp.next;
            idx--;
        }

        return temp.data;
    }

    // Function to add data at Head
    void addFirst(T data) {

        Node<T> newNode = new Node<T>(data);
        if(head == null) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // Function to remove tail data
    T removeLast() {
        if(tail == null) {
            System.out.println("Empty");
        }
        else if(tail == head) {
            T removed = head.data;
            head = null;
            tail = null;
            return removed;
        }
        else {
            Node<T> prev = null;
            Node<T> temp = head;

            while(temp.next != null) {
                prev = temp;
                temp = temp.next;
            }

            tail = prev;
            T removed = tail.data;
            if(tail != null) {
                tail.next = null;
            }
            size--;
            return removed;
        }
        return null;
    }

    // This func reverses the linked list 
    void reverse() {
        if(head == null) {
            System.out.println("Empty list");
            return;                             
        }                                       
        else if(head.next == null) {
            // do nothing
        }
        else {                                                          
            Node<T> prev = null;
            Node<T> cur = head;

            head = tail;
            tail = cur;
            
            while(cur != null)
            {
                Node<T> temp = cur.next;
                cur.next = prev;
                
                prev = cur;
                cur = temp;
            }
        }
    }

    // Function to remove the data at particular index
    void removeAt(int idx) {

        if(idx >= size) {
            System.out.println("Invalid index");
            return;
        }
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        else if(head.next == null) {
            head = null;
            tail = null;
            size--;
        }
        else {
            int x = idx;
            if(x == 0){
                Node<T> temp = head;
                head = head.next;
                temp.next = null;
                size--;
            }
            else {
                Node<T> temp = head;
                Node<T> prev = null;
                while(x > 0) {
                    prev = temp;
                    temp = temp.next;
                    x--;
                }
                prev.next = temp.next;
                temp.next = null;
                if(idx == size-1) {
                    tail = prev;
                }
                size--;
            }
        }
    }

    // Function to print the list
    void printList() {

        if(head == null) {
            System.out.println("Empty");
            return;
        }

        Node<T> temp = head;
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    // This function return head ptr
    Node<T> getHeadPtr() {
        return head;
    }

    // This function return tail ptr
    Node<T> getTailPtr() {
        return tail;
    }

    // function sets the head
    void setHead(Node<T> ptr) {
        head = ptr;
    }

    // function sets the tail
    void setTail(Node<T> ptr) {
        tail = ptr;
    }
}