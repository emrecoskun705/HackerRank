import java.util.List;

public class dksfj {
    public static void main(String[] args) {
        
    }
    public static int diagonalDifference(List<List<Integer>> arr) {
        int sumA = 0;
        int sumB = 0;
        for(int i=0; i<arr.size(); i++) {
            sumA += arr.get(i).get(i);
            sumB += arr.get(i).get(arr.size()-1-i);
        }
        return Math.abs(sumA-sumB);
    }
}
