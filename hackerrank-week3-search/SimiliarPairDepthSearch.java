import java.util.Scanner;

public class SimiliarPairDepthSearch {
    // I didn't do it. It is not finished!!!!!!!!!!!!!!!!!!!!!!!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] edges = new int[scanner.nextInt()-1][2];
        int k = scanner.nextInt();

        for(int i=0; i<edges.length; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }

        int counter = 0;
        for(int i=edges.length-1; i>=0; i--) {
            int j = i;
            while(edges[j][0] != edges[0][0]) {
                int dif = Math.abs(edges[j][0] - edges[i][1]);
                System.out.println(dif);
                if(dif < k) {
                    counter++;
                }
                j--;
            }
            if(Math.abs(edges[0][0] - edges[i][1]) < k) {
                counter++;
            }
        }

        System.out.println(counter);
    }
}
