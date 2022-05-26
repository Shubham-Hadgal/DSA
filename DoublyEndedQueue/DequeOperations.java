public class DequeOperations {
    public static void main(String[] args) {
        DoublyEndedQueue<Integer> dq = new DoublyEndedQueue<>(5);

        dq.pushFront(50);
        dq.prinQueue();

        dq.pushFront(60);
        dq.prinQueue();

        dq.pushBack(70);
        dq.prinQueue();

        dq.popFront();
        dq.prinQueue();

    }
}
