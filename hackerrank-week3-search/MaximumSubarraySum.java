import java.util.Arrays;
import java.util.Scanner;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long[] a = new long[scanner.nextInt()];
        long m = scanner.nextLong();

        for(int i=0; i<a.length; i++) {
            a[i] = scanner.nextLong();
        }


        for(int i=0; i<a.length; i++) {
            a[i] = a[i] % m;
        }
        Arrays.sort(a);

        long biggest = Long.MIN_VALUE;

        for(int i=0; i<a.length; i++) {
            a[i] = scanner.nextLong();
        }

    }
}
