import java.util.Arrays;
import java.util.Scanner;

public class GreedyFlorist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] c = new int[scanner.nextInt()];
        int k = scanner.nextInt();


        for(int i=0; i<c.length; i++) {
            c[i] = scanner.nextInt();
        }

        Arrays.sort(c);
        int sum = 0;
        int j=0;
        int counter = 0;
        //if counter == k means , program looked for the all friends and we need to add +1 to the "zam"(turkish)
        for(int i=c.length-1; i>=0; i--) {
            if(counter==k) {
                j++;
                counter=0;
            }
            sum += (j + 1) * c[i];

            counter++;
        }

        System.out.println(sum);



    }
}
