import java.util.Arrays;
import java.util.List;

public class Temp {
    public static void main(String[] args) {
        String s = "hjd";
        System.out.println(removeVowels(s));
    }

    public static String removeVowels(String str)
    {
        Character vowels[] = {'a', 'e', 'i', 'o', 'u','A','E','I','O','U'};
        
        List<Character> al = Arrays.asList(vowels);
        
        StringBuffer sb = new StringBuffer(str);
        
        for(int i = 0; i < sb.length(); i++) {
            if(al.contains(sb.charAt(i))){
                sb.replace(i, i+1, "") ;
                i--;
            }
        }
        return sb.toString();
    }
}
