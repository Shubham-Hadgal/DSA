public class CircularQueueOperations {
    public static void main(String[] args) {
        CircularQueue<Integer> cq = new CircularQueue<>(5);

        cq.add(10);
        cq.add(20);

        cq.add(30);
        cq.add(40);
        cq.add(50);

        cq.add(60); // full
        cq.add(70); // full

        cq.remove();
        cq.remove();

        cq.prinQueue(); // 30 40 50

        cq.remove(); 

        cq.prinQueue(); // 40 50

        cq.add(100); 
        cq.prinQueue(); // 40 50 100

        cq.add(140);
        cq.prinQueue(); // 40 50 100 140


        System.out.println(cq.getFront());
        System.out.println(cq.getRear());
    }
}
