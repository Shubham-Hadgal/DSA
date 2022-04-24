//  Program to Get Subsequence of String

// for rg: abc -> [---, a--, -b-, ab-, --c, a-c, -bc, abc]
// every character in string has an option to get add in or not to get add in. (a -> [-, a]).
import java.util.*;

public class GetSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        List<String> list = getSSQ(s);

        System.out.println(list);
        sc.close();
    }

    private static List<String> getSSQ(String s) {

        // base case 
        if(s.length() == 0) {
            List<String> temp = new ArrayList<>();
            // Every blank string has one subsequence which itself is blank
            temp.add("");
            return temp;
        }

        char ch = s.charAt(0); // extracted first char from string //-> a

        String ros = s.substring(1); // stored remaining string //-> bc

        List<String> rosans = getSSQ(ros); // got the ans of ros [--, b-, -c, bc] (RecLeapFaith)

        List<String> ans = new ArrayList<>(); // new string which is answer

        // a will interact as 'yes' and 'no' with every String in list ans.
        for(String rstr: rosans) {
            ans.add("-"+rstr);
            ans.add(ch+rstr);
        }

        // return final ans;
        return ans;
    }
}
