import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jumping_on_the_clouds {

    public static void main(String[] args) {
        int[] a = {0, 0, 1, 0, 0, 1, 0};
        System.out.println(jumpingOnClouds(new ArrayList(Arrays.asList(a))));
    }

    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        int i = 0;
        int cnt = 0;
        while(i < c.size()) {
            if(i==c.size()-1) break;
            if(i==c.size()-2) {
                cnt++;
                break;
            }
            if(c.get(i+2)==0) {
                i = i+2;
                cnt++;
            } else {
                i = i+1;
                cnt++;
            }
        }

        return cnt;
    }

}
