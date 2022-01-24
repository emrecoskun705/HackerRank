import java.util.List;

public class left_rotation {
    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        int lenA = a.size();
        int rotate = d % lenA;

        for(int i=0; i<rotate; i++) {
            a.add(a.remove(0));
        }
        return a;
    }
}
