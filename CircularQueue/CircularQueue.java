// * Circular Queue using arrau

class CircularQueue<T> {
    
    protected Object array[];
    protected int front = -1;
    protected int rear = -1;
    protected int size = 0;

    // creating queue of size n
    CircularQueue(int length) {
        array = new Object[length];
        size = length;
    }

    // return the front element
    public Object getFront() {
        return array[front];
    }


    // return the rear element
    public Object getRear() {
        return array[rear];
    }


    // checks whether the queue is full or not
    public boolean isFull() {

        if(front == 0 && rear == size-1) {
            return true;
        } else if(rear == (front-1)) {
            return true;
        } else {
            return false;
        }
    }

    // method to add element at the rear of queue
    public boolean add(T val) {
        if((front == 0 && rear == size-1) || (rear == front-1)) {
            System.out.println("Queue is Full");
            return false;
        }
        else if(rear == -1) {
            front = 0;
            rear = 0;
            array[rear] = val;
            return true;
        } else if(rear == size-1 && front != 0) {
            rear = 0;
            array[rear] = val;
            return true;
        } else {
            rear++;
            array[rear] = val;
            return true;
        }
    
    }


    // prints the queue in circular manner i.e front to rear
    public void prinQueue() {
        int ptr = front;

        while(ptr != rear) {
            System.out.print(array[ptr]+" ");
            if(ptr == size-1) {
                ptr = -1;
            }
            ptr++;
        }
        System.out.println(array[rear]);
    }

    // method to remove element from front of queue
    public boolean remove() {

        if(isEmpty()) {
            System.out.println("Queue is Empty");
            return false;
        }
        if(front == rear) {
            front = -1;
            rear = -1;
            return true;
        } else if (front == size-1) {
            front = 0;
        } else {
            front++;
            return true;
        }
        return false;
    }



    // checks whether queue is empty or not
    public boolean isEmpty() {
        return front == -1 ?  true: false;
    }
}
