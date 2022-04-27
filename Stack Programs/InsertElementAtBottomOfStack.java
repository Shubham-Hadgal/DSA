import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

/*
    *Algorithm
    1. store the stack top element in variable and pop element from stack.
    2. hit recursive call
    3. follow step 1 & 2 until stack becomes empty.
    4. if stack is empty push x element in stack and return;
*/

public class InsertElementAtBottomOfStack {
    public static void main(String[] args) {
        Stacks<Integer> st = new Stacks<>();

        st.push(10);
        st.push(110);
        st.push(1);
        st.push(230);
        st.push(45);
        st.push(20);

        st.printStack();
        Stacks<Integer> ans = enterAtTheBottom(st, 98);
        ans.printStack();
    }

    // function to enter element at bottom
    private static Stacks<Integer> enterAtTheBottom(Stacks<Integer> st, int val) {
        solve(st, val);
        return st;
    }

    // helper function
    private static void solve(Stacks<Integer> st, int val) {
        
        // ! base case
        if(st.isEmpty()) {
            st.push(val);
            return;
        }

        int temp = st.pop();

        // ! recursive call
        solve(st, val);

        st.push(temp);
    }


    // *Testing the Above Code
    // *Test Cases
    @Test
    public void test1() {
        Stacks<Integer> st = new Stacks<>();
        st.push(10);
        st.push(78);
        st.push(56);
        st.push(12);

        Stacks<Integer> ans = enterAtTheBottom(st, 90);

        String expected = "12 56 78 10 90 ";
        String answer;
        StringBuilder sb = new StringBuilder();

        while(!ans.isEmpty()) {
            sb.append(ans.pop()+" ");
        }
        answer = sb.toString();
        assertEquals(expected, answer);

    }

    @Test
    public void test2() {
        Stacks<Integer> st = new Stacks<>();
        st.push(10);
        st.push(20);

        Stacks<Integer> ans = enterAtTheBottom(st, 30);

        String expected = "20 10 30 ";
        String answer;
        StringBuilder sb = new StringBuilder();

        while(!ans.isEmpty()) {
            sb.append(ans.pop()+" ");
        }
        answer = sb.toString();
        assertEquals(expected, answer);

    }

    @Test
    public void test3() {
        Stacks<Integer> st = new Stacks<>();
        st.push(10);
        st.push(340);
        st.push(21);
        st.push(27);
        st.push(28);
        st.push(20);
        st.push(40);
        st.push(30);
        st.push(60);
        st.push(276);
        st.push(256);
        st.push(212);
        st.push(245);
        st.push(278);
        st.push(212);
        st.push(670);
        st.push(234);
        st.push(2090);
        st.push(346);
        st.push(220);
        st.push(120);

        Stacks<Integer> ans = enterAtTheBottom(st, 30);

        String expected = "120 220 346 2090 234 670 212 278 245 212 256 276 60 30 40 20 28 27 21 340 10 30 ";
        String answer;
        StringBuilder sb = new StringBuilder();

        while(!ans.isEmpty()) {
            sb.append(ans.pop()+" ");
        }
        answer = sb.toString();
        assertEquals(expected, answer);

    }
    @Test
    public void test4() {
        Stacks<Integer> st = new Stacks<>();

        Stacks<Integer> ans = enterAtTheBottom(st, 30);

        String expected = "30 ";
        String answer;
        StringBuilder sb = new StringBuilder();

        while(!ans.isEmpty()) {
            sb.append(ans.pop()+" ");
        }
        answer = sb.toString();
        assertEquals(expected, answer);

    }
}
