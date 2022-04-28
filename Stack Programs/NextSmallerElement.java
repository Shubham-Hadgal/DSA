/*
    ! Algorithm
    1. create a stack and push -1 initially.
    2. create answer array.
    3. start loop from ans.length-1
            1. if st.peek() < iparr[i] -> set ith element to st.peek()
                and push arr[i] to stack.
            2. else pop elements from stack until st.peek() > arr[i]
                when we found smaller element puth that in ith index and push arr[i] in stack

*/

public class NextSmallerElement {
    public static void main(String[] args) {
        int arr[] = {11, 13, 21, 3};

        int ans[] = getNextSmallerElements(arr);

        for(int i: ans) {
            System.out.print(i+" ");
        }
    }

    // method to get nextSmallerElements
    private static int[] getNextSmallerElements(int[] arr) {

        // step1
        Stacks<Integer> st = new Stacks<>();
        st.push(-1);

        // step 2
        int ans[] = new int[arr.length];

        // step 3
        for(int i = arr.length-1; i >= 0; i--) {
            if(st.peek() < arr[i]) {
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
