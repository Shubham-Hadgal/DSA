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

    public T front() {
        return list.getFirst();
    }

    public T rear() {
        return list.getLast();
    }

    public void print() {
        list.printList();
    }

    public boolean isEmpty() {
        return (size == 0) ? true: false;
    }
}
