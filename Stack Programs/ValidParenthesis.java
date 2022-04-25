import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "{({}))}";

        boolean isValid = validParenthesis(s);

        System.out.println(isValid);
    }

    private static boolean validParenthesis(String s) {
        Stacks<Character> st = new Stacks<>();

        for(int i = 0; i < s.length(); i++) {
           if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
               st.push(s.charAt(i));
           } else {
               if(!st.isEmpty()) {
                   if(st.peek() == '(' && s.charAt(i) == ')' || st.peek() == '{' && s.charAt(i) == '}' || st.peek() == '[' && s.charAt(i) == ']') {
                       st.pop();
                   } else {
                       return false;
                   }
               } else {
                   return false;
               }
           }
        }
        if(st.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void test1() {
        assertEquals(false, validParenthesis("{({}[))}"));
    }
    @Test
    public void test2() {
        assertEquals(false, validParenthesis("{({}))}"));
    }
    @Test
    public void test3() {
        assertEquals(true, validParenthesis("{({})}"));
    }
    @Test
    public void test4() {
        assertEquals(true, validParenthesis("{(({}[]))}"));
    }
    @Test
    public void test5() {
        assertEquals(false, validParenthesis("[{({}[))})"));
    }
    @Test
    public void test6() {
        assertEquals(false, validParenthesis("{[({}))}"));
    }
}
