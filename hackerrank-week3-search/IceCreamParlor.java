public class IceCreamParlor {

    static int[] icecreamParlor(int m, int[] arr) {
        int[] answer = new int[2];
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] + arr[j] == m) {
                    answer[0] = i+1;
                    answer[1] = j+1;
                    break;
                }
            }
        }

        return answer;
    }

}
