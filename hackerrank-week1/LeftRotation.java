import java.util.List;

public class LeftRotation {
    public static List<Integer> rotateLeft(int d, List<Integer> arr) {

        for(int i=0; i<d; i++) {
            arr.add(arr.get(0));
            arr.remove(0);
        }
        return arr;
    }

    public static void main(String[] args) {
        long a = 3;
        int b = 1;
        System.out.println(a+b);
    }
}
