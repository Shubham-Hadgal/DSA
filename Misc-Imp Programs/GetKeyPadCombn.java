// Program to print KeyPadCombn

// for eg : i/p = "73", o/p = [tg, th, ti, ug, uh, ui]

// explanation 7 = "tu", 3 = "ghi"  every char in 7th string interacts with every char in 3rd string

import java.util.*;

public class GetKeyPadCombn {
//                             0    1     2     3     4     5     6      7    8     9
    static String codes[] = {".,","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String ques = sc.nextLine();

        List<String> ans = getKeyPadCombn(ques);


        System.out.println(ans);
        sc.close();
    }

    private static List<String> getKeyPadCombn(String ques) {
        //ques = "573"

        // base case
        if(ques.length() == 0) {
            // return new list with empty content as string size = 0
            List<String> temp = new ArrayList<>();
            temp.add("");
            return temp;
        }
        
        // extract first char from ques
        char ch = ques.charAt(0);

        // store remaining ques
        String ros = ques.substring(1);

        // keep faith this works for smaller problem i.e "73" (RecLeapFaith)
        List<String> spAns = getKeyPadCombn(ros); // get combn of 73

        List<String> orgAns = new ArrayList<>(); // new list for 573

        // parse ch into int and get respective string i.e "mno"
        int n = Integer.parseInt(String.valueOf(ch));
        String code = codes[n];

        // traverse in code i.e "mno"
        for(int i = 0; i < code.length(); i++) {
            char itr = code.charAt(i);
            // interact every char in code = "mno" with 73's result. and store int orgAns list
            for(String temp: spAns) {
                orgAns.add(itr+temp);
            }
        }

        // return orgAns
        return orgAns;

    }
}
