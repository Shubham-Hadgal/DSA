class Queues<T> {
    private int size;
    LinkedLists<T> list;

    public Queues() {
        size = 0;
        list = new LinkedLists<>();
    }

    public int size() {
        return list.size;
    }

    public void add(T data) {
        size++;
        list.addAtLast(data);
    }

    public void remove() {
        size--;
        list.removeFirst();
    }

    public T peek() {
        return list.getFirst();
    }

    public void print() {
        list.printList();
    }
}
