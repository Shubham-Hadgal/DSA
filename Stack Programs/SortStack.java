/*
    ! Algorithm
    1. store the stack top element in variable n and pop element from stack.
    2. do recursive call this will sort a stack (RLF)
    3. now place n in its correct position.
*/

public class SortStack {
    public static void main(String[] args) {
        Stacks<Integer> st = new Stacks<>();

        st.push(89);
        st.push(23);
        st.push(56);
        st.push(-9);

        st.printStack();
        sortStack(st);
        st.printStack();

    }

    // methhod to sort a stack
    private static void sortStack(Stacks<Integer> st) {

        // base case
        if(st.isEmpty()) {
            return;
        }

        // store top element
        int n = st.pop();
        
        // this will sort a stack (RLF)
        sortStack(st);

        // insert element at correct position in sorted array
        insertAtCorrectPosition(st, n);
    }

    // method to insert element at correct position in stack 
    private static void insertAtCorrectPosition(Stacks<Integer> st, int n) {


        // base case
        if(st.isEmpty()) {
            st.push(n);
            return;
        }

        // inserting element at its correct position
        if(st.peek() > n) {
            int ele = st.pop();
            insertAtCorrectPosition(st, n);
            st.push(ele);
        } else {
            st.push(n);
        }
    }
}
