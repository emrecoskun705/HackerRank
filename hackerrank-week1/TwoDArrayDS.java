import java.util.concurrent.Callable;

public class TwoDArrayDS {



    // only answer
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int answer = Integer.MIN_VALUE;
        for(int i=0; i<arr.length-2; i++) {
            for(int j=0; j<arr.length-2; j++) {
                int possibleAnswer =   arr[i][j] + arr[i][j+1] + arr[i][j+2] +
                        arr[i+1][j+1] +
                        arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                if (possibleAnswer > answer) {
                    answer = possibleAnswer;
                }
            }
        }

        return answer;
    }

 


}
