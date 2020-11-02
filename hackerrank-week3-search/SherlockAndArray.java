import java.util.List;

public class SherlockAndArray {
    static String balancedSums(List<Integer> arr) {
        int leftTotal = 0;
        int rightTotal = 0;
        for(int i=1; i<arr.size(); i++) {
            rightTotal += arr.get(i);
        }
        if(rightTotal == 0) return "YES";

        for(int i=1; i<arr.size(); i++) {
            leftTotal += arr.get(i-1);
            rightTotal -= arr.get(i);
            if (leftTotal == rightTotal) return "YES";
            else if (leftTotal > rightTotal) return "NO";
        }
        return "NO";
    }
}
