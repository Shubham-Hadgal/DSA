/*
    * Given valid mathematical expressions in the form of a string. You are supposed to return true if the given expression contains a pair of redundant brackets, else return false. The given string only contains (, ), +, -, *, / and lowercase English letters.
    *   redundant braces means extra needless braces i.e every bracket consumes at least one operator.

    ! Algorithm
    1. create stack.
    2. if charAt(i) is open brace or any operator then push it in stack.
    3. if charAt(i) is closing brace then check for operator in stack till we find opening brace
    4. when we find open brace set boolean to false and pop the open brace.
    5. if not found then set boolean to true and return.

*/

public class RedundantBrackets {
    public static void main(String[] args) {
        String ip = "(a+b+c(a/g)(f+y))";

        boolean isRedundant = checkRedundant(ip);

        System.out.println(isRedundant);
    }


    // method to checkRedundant braces
    private static boolean checkRedundant(String ip) {

        // step 1
        Stacks<Character> st = new Stacks<>();

        
        for(int i = 0 ; i < ip.length(); i++) {

            // step 2
            if(ip.charAt(i) == '(' || ip.charAt(i) == '+' || ip.charAt(i) == '*' || ip.charAt(i) == '-' || ip.charAt(i) == '/') {
                st.push(ip.charAt(i));
            }
            // step 3
            else if(ip.charAt(i) == ')'){
                boolean isRedundant = true;
                while(st.peek() != '(') {
                    char top = st.peek();
                    if(top == '+' || top == '*' || top == '/' || top == '-') {
                        // step 4
                        isRedundant = false;
                    }
                    st.pop();
                }
                // step 5
                if(isRedundant) {
                    return true;
                }
                st.pop();
            }
        }

        return false;
    }
}
