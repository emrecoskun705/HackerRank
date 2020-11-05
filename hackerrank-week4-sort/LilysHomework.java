import java.util.*;
import java.util.stream.IntStream;

public class LilysHomework {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[scanner.nextInt()];
        for (int i=0; i<arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] arr2 = Arrays.copyOf(arr,arr.length);

        int[] sorted = new int[arr.length];
        for (int i=0; i<arr.length; i++) {
            sorted[i] = arr[i];
        }
        Arrays.sort(sorted);
        int[] reversed = new int[arr.length];
        for (int i=0; i<arr.length; i++) {
            reversed[arr.length-1-i] = sorted[i];
        }

        int count1 = calculate(sorted, arr);
        int count2 = calculate(reversed, arr2);
        System.out.println(count1);
        System.out.println(count2);
    }

    static int calculate(int[] sorted, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            map.put(arr[i], i);
        }

        int count = 0;
        for(int i=0; i<sorted.length; i++) {
            if(arr[i] != sorted[i]) {
                int mapIdx = map.get(sorted[i]);
                map.put(arr[i], mapIdx);
                map.put(sorted[i], i);
                swap(arr, mapIdx, i);
                count++;
            }
        }

        return count;
    }

    static void swap(int[] arr ,int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }


}


