import java.util.*;

public class Pairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[scanner.nextInt()];
        int k = scanner.nextInt();

        for(int i=0; i<arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);
        int counter = 0;
        asd:
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                int dif = Math.abs(arr[i] - arr[j]);
                //System.out.println("dif is: " + dif);
                if(dif == k) {
                    counter++;
                    continue asd;
                }
            }
        }

        System.out.println(counter);
    }


}
