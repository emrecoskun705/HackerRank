import java.util.Collections;
import java.util.List;

public class mark_and_toys {
    public static int maximumToys(List<Integer> prices, int k) {
        // Write your code here
        Collections.sort(prices);
        int sum = 0;
        int cnt = 0;
        for(int i : prices) {
            if(sum+i <= k) {
                sum += i;
                cnt++;
            } else {
                break;
            }
        }

        return cnt;
    }
}
