import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortAdvancedAnalysis {
// hackerrankteyken tpye long olmalı önemli not
//bazı typlerı longa çevirmen lazım unutma
//özellikle method ları int den longa ve count type ı da longa çevirmen lazım
    public static void main(String[] args) {
        ArrayList<Integer> answers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++) {
            int[] arr = new int[scanner.nextInt()];
            for(int j=0; j<arr.length; j++) {
                arr[j] = scanner.nextInt();
            }
            answers.add(sort(arr));

        }
        System.out.println(answers);
    }

    static int sort(int[] arr) {
        int count = 0;
        int mid = arr.length / 2;
        if(mid > 0) {


            int[] left = new int[mid];
            int[] right;
            if (arr.length % 2 == 0) {
                right = new int[mid];
            } else {
                right = new int[mid + 1];
            }

            for (int i = 0; i < mid; i++) {
                left[i] = arr[i];
            }
            for (int i = 0; i < right.length; i++) {
                right[i] = arr[mid + i];
            }

            System.out.println(count);
            count += sort(left);
            count += sort(right);
            count += merge(left, right, arr);
        }
        return count;

    }

    static int merge(int[] left, int[] right, int[] arr) {
        int count = 0;
        int leftP, rightP, i;
        leftP = rightP = i = 0;

        while (leftP < left.length && rightP < right.length) {
            if(left[leftP] <= right[rightP]) {
                arr[i++] = left[leftP++];
            } else {
                arr[i++] = right[rightP++];
                count += left.length - leftP;
            }
        }

        while (leftP < left.length) {
            arr[i++] = left[leftP++];
        }
        while (rightP < right.length) {
            arr[i++] = right[rightP++];
        }


        return count;
    }

}
