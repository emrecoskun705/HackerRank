import java.util.*;

public class ClosestNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[scanner.nextInt()];
        for(int i=0; i<arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);
        int minDiff = arr[1] - arr[0];
        for(int i=2; i<arr.length; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i-1]);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=1; i<arr.length; i++) {
            if(arr[i] - arr[i-1] == minDiff) {
                answer.add(arr[i]);
                answer.add(arr[i-1]);
            }
        }

        System.out.println(answer);

        scanner.close();
    }
}
