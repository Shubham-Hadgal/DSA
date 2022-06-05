import java.util.*;
/*
    ! Algorithm
    1. traverse the input string.
        2. store count of each element
        3. push current char in queue.
        4. process repeated and Non repeated element
            if(dq.getFirstCount > 1) then add to ans and break
            else pop() the element.
        5. if queue is empty add # to ans; 
 */
public class FirstNonRepeatingCharInStream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        System.out.println(firstNonRepeatingCharInStream(input));
        sc.close();

    }

    private static String firstNonRepeatingCharInStream(String input) {
        StringBuilder ans = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        Deque<Character> dq = new ArrayDeque<>();

        for(int i = 0; i < input.length(); i++) {

            // increase count of character
            if(map.containsKey(input.charAt(i))) {
                map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
            } else {
                map.put(input.charAt(i), 1);
            }
            
            // push element in queue
            dq.offer(input.charAt(i));
            
            // process the non repeated and repeated element
            while(!dq.isEmpty()) {
                if(map.get(dq.getFirst()) > 1) {
                    dq.poll();
                } else {
                    ans.append(dq.getFirst());
                    break;
                }
            }

            // if queue is empty add # to string
            if(dq.isEmpty()) {
                ans.append('#');
            }
        }
        return ans.toString();
    }
}
