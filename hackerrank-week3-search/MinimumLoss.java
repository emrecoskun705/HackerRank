import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MinimumLoss {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long[] price = new long[scanner.nextInt()];

        for(int i=0; i<price.length; i++) {
            price[i] = scanner.nextLong();
        }
        // first of all we need to find the index of each element in the array,
        // then we mapped them into a hashmap first
        // in hashmap Long is 
        HashMap<Long, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<price.length; i++) {
            if(map.get(price[i]) == null) {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                map.put(price[i], arr);
            } else {
                ArrayList<Integer> arr = map.get(price[i]);
                arr.add(i);
                map.put(price[i], arr);
            }
        }

        Arrays.sort(price);

        long smallest =Long.MAX_VALUE;
        for(int i=price.length-1; i > 0; i--) {
            long temp = price[i] - price[i-1];
            if(price[i] - price[i-1] < smallest) {
                ArrayList<Integer> indexes1 = map.get(price[i]);
                ArrayList<Integer> indexes2 = map.get(price[i-1]);
                for(int index1 : indexes1) {
                    for(int index2: indexes2) {
                        if(index1 - index2 < 0) {
                            smallest = temp;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(smallest);
    }

}
