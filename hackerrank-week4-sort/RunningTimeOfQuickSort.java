import java.util.ArrayList;
import java.util.Scanner;


public class RunningTimeOfQuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<scanner.nextInt(); i++) {
            arr.add(scanner.nextInt());
        }

        int q = quickSort(arr, 0, arr.size()-1);
    }

    static int quickSort(ArrayList<Integer> arr, int lo, int hi) {
        int pivot = arr.get(hi);

        int i = lo;
        int total = 0;
        for(int j=lo; j<hi; j++) {
            if(arr.get(j) < pivot) {
                arr = swap(arr, i, j);
                total += 2;
                i++;
            }
        }
        arr = swap(arr, i, hi);
        return i;
    }
    static ArrayList<Integer> swap(ArrayList<Integer> arr, int p1, int p2) {
        int smallValue = arr.get(p1);
        int bigValue = arr.get(p2);

        arr.set(p1, bigValue);
        arr.set(p2, smallValue);

        return arr;
    }
}
