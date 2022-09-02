import java.util.*;

public class Temp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int ans = getMax(s);
        System.out.println(ans);
        sc.close();
    }

    public static int getMax(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0 ;i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        return map.size();

    }
}
