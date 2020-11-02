import java.util.Scanner;

public class RunningTimeOfAlgorithms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[scanner.nextInt()];
        for(int i=0; i<arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        //insertion sort
        int total = 0;
        for(int i=1; i<arr.length; i++) {
            int tmp = arr[i];
            int j = i;

            while(j>0 && arr[j-1] > tmp) {
                arr[j] = arr[j-1];
                total += 1;
                j--;
            }
            arr[j] = tmp;
        }

        System.out.println(total);

    }
}
