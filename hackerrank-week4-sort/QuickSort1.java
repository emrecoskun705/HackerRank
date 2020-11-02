import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QuickSort1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[scanner.nextInt()];
        for(int i=0; i<arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        int pivot = 0;

        for(int i=1; i<arr.length; i++) {
            System.out.println(arr[pivot]);
            if(arr[pivot] > arr[i]) {
                for(int j=i; j>0; j--) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j-1] = temp;
                }
                pivot++;
            }
        }


        System.out.println(Arrays.toString(arr));





    }
}
