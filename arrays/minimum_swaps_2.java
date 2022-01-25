public class minimum_swaps_2 {
    static int minimumSwaps(int[] arr) {

        int cnt = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != i+1) {
                int k = arr[i];
                // if new location is same as current location change directly
                if(arr[k-1]==i+1) {
                    int tmp = arr[k-1];
                    arr[k-1] = k;
                    arr[i] = tmp;
                    cnt++;
                } else {
                    for(int j=i+1; j<arr.length; j++) {
                        if(arr[j] == i+1) {
                            int tmp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = tmp;
                            cnt++;
                            break;
                        }
                    }
                }

            }
        }

        return cnt;
    }
}
