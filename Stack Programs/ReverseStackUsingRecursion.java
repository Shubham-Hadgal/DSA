/*
    ! Algorithm
    1. check if stack is not empty or size == 1
    2. store the stack top element in variable n and pop element from stack.
    3. recursive call for reversing the stack.
    4. then insert n in bottom of stack.

*/

public class ReverseStackUsingRecursion {
    public static void main(String[] args) {
        Stacks<Integer> st = new Stacks<>();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        st.printStack();
        reverseStack(st);
        st.printStack();
    }

    // method to reverse Stack.
    private static void reverseStack(Stacks<Integer> st) {

        // base case
        if(st.size() == 1 || st.isEmpty()) {
            return;
        }

        // poping top element
        int n = st.pop();

        // reversing remaining stack
        reverseStack(st);

        // inserting n at bottom of stack
        insertAtBottom(st, n);
    }

    // method to insert element at bottom of stack
    private static void insertAtBottom(Stacks<Integer> st, int n) {
        if(st.isEmpty()) {
            st.push(n);
            return;
        }

        int val = st.pop();
        insertAtBottom(st, n);

        st.push(val);
    }
}