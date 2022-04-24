import java.util.*;

public class GetStairPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<String> list = getStairPaths(n);

        System.out.println(list);
        sc.close();
    }

    private static List<String> getStairPaths(int n) {
        
        if(n == 0) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        else if(n < 0) {
            List<String> list = new ArrayList<>();
            return list;
        }
        List<String> p1 = getStairPaths(n-1);
        List<String> p2 = getStairPaths(n-2);
        List<String> p3 = getStairPaths(n-3);

        List<String> list = new ArrayList<>();

        for(String paths: p1) {
            list.add(1+paths);
        }
        for(String paths: p2) {
            list.add(2+paths);
        }
        for(String paths: p3) {
            list.add(3+paths);
        }
        return list;
    }
}
