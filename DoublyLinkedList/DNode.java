public class DNode<T> {
    T data;
    DNode<T> next;
    DNode<T> prev;

    DNode(T data) {
        this.data = data;
        next = null;
        prev = null;
    }
}
