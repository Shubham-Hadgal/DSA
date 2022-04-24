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
}
