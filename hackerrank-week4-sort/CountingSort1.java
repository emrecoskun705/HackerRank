import java.util.Arrays;
import java.util.Scanner;

public class CountingSort1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[scanner.nextInt()];
        for(int i=0; i<arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] counter = new int[100];
        for(int i=0; i<arr.length; i++) {
            counter[arr[i]]++;
        }

        System.out.println(Arrays.toString(counter));

    }
}
