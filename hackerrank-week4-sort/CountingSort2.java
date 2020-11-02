import java.util.Arrays;
import java.util.Scanner;

public class CountingSort2 {
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
        int[] answer = new int[arr.length];

        int j = 0;
        for(int i=0; i<counter.length; i++) {
            while(counter[i] != 0) {
//                System.out.println(j + " " + i);
                answer[j] = i;
                counter[i]--;
                j++;
            }
        }

        System.out.println(Arrays.toString(answer));

    }
}
