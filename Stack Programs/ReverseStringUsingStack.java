import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReverseStringUsingStack {
    public static void main(String[] args) {
        String s = "Tiger";
        System.out.println(reverse(s));
    }

    private static String reverse(String s) {
        Stacks<Character> st = new Stacks<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
        }

        while(!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.toString();
    }

    @Test
    public void test1() {
        assertEquals("mahbuhS", reverse("Shubham"));
    }
    @Test
    public void test2() {
        assertEquals("nitin", reverse("nitin"));
    }
    @Test
    public void test3() {
        assertEquals("ereht olleh", reverse("hello there"));
    }
    @Test
    public void test4() {
        assertEquals("aicodappac", reverse("cappadocia"));
    }
    @Test
    public void test5() {
        assertEquals("sevidlaM", reverse("Maldives"));
    }
}
