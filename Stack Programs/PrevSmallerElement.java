/*
    ! Algorithm
    1. create a stack and push -1 initially.
    2. create answer array.
    3. start loop from 0th index
            1. if st.peek() < iparr[i] -> set ith element to st.peek()
                and push arr[i] to stack.
            2. else pop elements from stack until st.peek() > arr[i]
                when we found smaller element puth that in ith index and push arr[i] in stack

*/

public class PrevSmallerElement {
    public static void main(String[] args) {
        int arr[] = {4, 8, 5, 2, 25 };

        int ans[] = getPreviousSmallerElements(arr);

        for(int i: ans) {
            System.out.print(i+" ");
        }
    }

    private static int[] getPreviousSmallerElements(int[] arr) {
        Stacks<Integer> st = new Stacks<>();
        st.push(-1);
        int ans[] = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > st.peek()) {
                ans[i] = st.peek();
                st.push(arr[i]);
            } else {
                while(st.peek() > arr[i]) {
                    st.pop();
                }
                ans[i] = st.peek();
                st.push(arr[i]);
            }
        }
        return ans;
    }
}
