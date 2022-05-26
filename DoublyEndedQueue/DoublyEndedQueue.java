// *Doubly Ended Queue is a Circular Queue with extra functinality.

class DoublyEndedQueue<T> extends CircularQueue<T> {

    // calls Parent Constructor
    DoublyEndedQueue(int length) {
        super(length);
    }

    // method to add element at front of the queue
    public void pushFront(T val) {
        if(isFull()) {
            System.out.println("Queue is Full.");
            return;
        } else if(front == -1) {
            front = 0;
            rear = 0;
            array[front] = val;
        } else if(front == 0) {
            front = size-1;
            array[front] = val;
        } else {
            front--;
            array[front] = val;
        }
    }

    // method to add element at the rear of queue
    public void pushBack(T val) {
        add(val);
    }

    // method to remove element from front of queue
    public void popFront() {
        remove();
    }

    // method to remove element from rear of queue
    public void popBack() {
        if(isEmpty()) {
            System.out.println("Queue is Empty.");
            return;
        } else if(rear == 0) {
            front = -1;
            rear = -1;
        } else if(rear == 0){
            rear = size-1;
        } else {
            rear--;
        }
    }
    
}
