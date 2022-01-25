import java.util.List;

public class sorting_bubble_sort {
    public static void countSwaps(List<Integer> a) {
        // Write your code here
        int cnt = 0;
        for(int i=0; i<a.size(); i++) {
            for(int j=0; j<a.size()-1; j++) {
                if(a.get(j) > a.get(j+1)) {
                    int tmp = a.get(j);
                    a.set(j, a.get(j+1));
                    a.set(j+1, tmp);
                    cnt++;
                }
            }
        }

        System.out.println("Array is sorted in " + cnt + " swaps.\nFirst Element: " + a.get(0) + "\nLast Element: " + a.get(a.size()-1));
    }

}
