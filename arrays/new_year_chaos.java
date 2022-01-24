import java.util.List;

public class new_year_chaos {
    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int cnt = 0;
        for(int i=q.size()-1; i>=0; i--) {
            if(q.get(i) - (i+1) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            if((i-1 >= 0) && q.get(i-1)==i+1) {
                int tmp = q.get(i-1);
                q.set(i-1, q.get(i));
                q.set(i, tmp);
                cnt++;
            } else if((i-2 >= 0) && q.get(i-2)==i+1) {
                int tmp = q.get(i-2);
                q.set(i-2, q.get(i-1));
                q.set(i-1, q.get(i));
                q.set(i, tmp);
                cnt += 2;
            }
        }

        System.out.println(cnt);
    }
}
