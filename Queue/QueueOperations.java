public class QueueOperations {
    public static void main(String[] args) {
        Queues<Integer> q = new Queues<>();

        q.add(10);
        q.add(30);
        q.add(5);
        q.add(676);

        // now q = 10 30 5 676

        q.print();

        System.out.println(q.peek());
        System.out.println(q.size());

        q.remove();
        q.remove();

        q.print();
        System.out.println(q.size());

    }
}
