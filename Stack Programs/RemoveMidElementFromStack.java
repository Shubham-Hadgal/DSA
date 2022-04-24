/*
    * Program to delete middle element from stack

    ! Algorithm
        1. get mid count by doing size / 2.
        2. save that top element
        3. hit recursive calls by count + 1 until count != size / 2.
        4. when count == size / 2 pop that element and return.
        5. push that saved element to stack.
*/

public class RemoveMidElementFromStack {
    public static void main(String[] args) {
        Stacks<Integer> st = new Stacks<>();

        st.push(10);
        st.push(5);
        st.push(23);
        st.push(12);
        st.push(29);

        st.printStack();
        deleteMid(st, st.size());
        st.printStack();
    }
    
    private static void deleteMid(Stacks<Integer> st, int size) {
        int count = 0;
        solve(st, count, size);
    }

    private static void solve(Stacks<Integer> st, int count, int size) {
        if(count == size/2) {
            st.pop();
            return;
        }
        int temp = st.pop();
        solve(st, count+1, size);
        st.push(temp);
    }
}
