
public class StackOperations {
    public static void main(String[] args) {
        Stacks<Integer> st = new Stacks<>(5);
        st.push(10);
        st.push(20);
        st.push(80);
        st.push(10);
        st.push(20);
        st.push(19);
   

        st.printStack();
        System.out.println(st.peek());
        System.out.println("size : "+ st.size());
        st.pop();
        st.printStack();
        System.out.println(st.size());
        System.out.println(st.peek());
    }
}
