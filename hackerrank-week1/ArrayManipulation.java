public class ArrayManipulation {
    static long arrayManipulation(int n, int[][] queries) {
        int r = queries.length;
        long[] arr = new long[n+2];
        long answer = 0;
        for(int i=0; i<r; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int k = queries[i][2];
            arr[a] += k;
            arr[b+1] -= k;
        }
        long total = 0;
        for(int i=0; i<arr.length; i++) {
            total += arr[i];
            if(total > answer) {
                answer = total;
            }
        }


        return answer;
    }

}
