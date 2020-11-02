import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[scanner.nextInt()];
        for(int i=0; i<arr.length; i++) {
            arr[i] = scanner.nextInt();
        }


        for(int i=1; i<arr.length; i++) {
            int tmp = arr[i];
            int j;

            for(j = i; j>0 && arr[j-1] > tmp; j--) {
                arr[j] = arr[j-1];
                printArr(arr);
            }

            arr[j] = tmp;
        }
        printArr(arr);
    }

    static void printArr(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
