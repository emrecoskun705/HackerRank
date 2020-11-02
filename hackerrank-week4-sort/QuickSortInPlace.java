import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QuickSortInPlace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[scanner.nextInt()];

        for(int i=0; i<arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            arrayList.add(arr[i]);
        }
        quickSort(arrayList, 0, arr.length-1);
    }

    static void quickSort(ArrayList<Integer> arr, int lo, int hi) {
        if(lo < hi) {
            int p = partition(arr, lo, hi);

            printArray(arr);
            quickSort(arr, lo, p-1);
            quickSort(arr, p+1, hi);
        }
    }

    static int partition(ArrayList<Integer> arr, int lo, int hi) {
        int pivot = arr.get(hi);

        int i = lo;
        for(int j=lo; j<hi; j++) {
            if(arr.get(j) < pivot) {
                arr = swap(arr, i, j);
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





    static void printArray(ArrayList<Integer> ar) {
        for(int i=0;i<ar.size();i++){
            System.out.print(ar.get(i)+" ");
        }
        System.out.println("");
    }

}









