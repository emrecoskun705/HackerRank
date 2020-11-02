import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {

    // my answer
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[scanner.nextInt()];
        int k = scanner.nextInt();

        for(int i=0; i<arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);
        int[] subarr = new int[k];


        int smallest = Integer.MAX_VALUE;
        for(int i=0; i<=arr.length-k; i++) {
            int j=0;
            while(j != k) {
                subarr[j] = arr[i+j];
                j++;
            }
            int possible = subarr[k-1] - subarr[0];
            if(possible < smallest) smallest = possible;
        }

        System.out.println(smallest);
    }

    //another solution

    static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for(int i=0; i<= arr.length - k; i++) {
            min = Math.min(min, arr[k + i - 1] - arr[i]);
        }

        return min;
    }
}
