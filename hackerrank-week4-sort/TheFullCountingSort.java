import java.util.*;
import java.util.stream.Collectors;

public class TheFullCountingSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();


        StringBuffer[] answer = new StringBuffer[100];
        for(int i=0; i<answer.length; i++) {
            answer[i] = new StringBuffer("");
        }

        for(int i=0; i<n/2; i++) {
            int index = scanner.nextInt();
            String word = scanner.next();
            answer[index].append("- ");

        }

        for(int i=n/2; i<n; i++) {
            int index = scanner.nextInt();
            String word = scanner.next();
            answer[index].append(word).append(" ");
        }

        for(int i=0; i<answer.length; i++) {
            if(!answer[i].toString().equals(""))
            System.out.print(answer[i].toString());
        }



    }
}
