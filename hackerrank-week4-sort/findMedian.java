import java.util.Arrays;

public class findMedian {
    static int findMedian1(int[] arr) {
        Arrays.sort(arr);
        if(arr.length % 2 == 1) {
            return arr[arr.length / 2];
        } else {
            return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
        }

    }
}
