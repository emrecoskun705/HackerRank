import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CountLuck2Hckrnk {

    static int N;
    static int M;
    static String[][] matrix;
    static String countLuck(String[] lines, int k) {
        N = lines.length;
        M = lines[0].length();
        matrix = new String[N][M];
        for(int i=0; i<N; i++) {
            String line = lines[i];
            for(int j=0; j<M; j++) {
                matrix[i][j] = line.substring(j,j+1);
            }
        }

        int[] location = findLocation(matrix);
        int count = countLuck1(matrix, k, location);
        if(count == k) {
            return "Impressed";
        } else {
            return "Oops!";
        }


    }

    static int countLuck1(String[][] matrix, int k, int[] location) {
        boolean[][] isValid = new boolean[N][M];
        isValid[location[0]][location[1]] = true;
        int[][] totalMovements = new int[N][M];

        totalMovements[location[0]][location[1]] = 1;
        int[][] moves = new int[][] {
                {1,0}, {0,1}, {-1,0}, {0,-1},
        };

        ArrayList<int[]> query = new ArrayList<>();
        query.add(location);
//        printIsValid(isValid);


        while (!query.isEmpty()) {
//            printQuery(query);
//            System.out.println();
            int[] curLocation = query.remove(0);;
            int row = curLocation[0];
            int col = curLocation[1];
            if(matrix[row][col].equals("*")) {
                return wandWave(row, col, totalMovements);
            }

            for(int[] arr : moves) {
                int newRow = row + arr[0];
                int newCol = col + arr[1];
                int[] newLoc = new int[] {newRow, newCol};


                if(isValidLocation(newLoc) && !isValid[newRow][newCol] && !matrix[newRow][newCol].equals("X")) {

                    isValid[newRow][newCol] = true;
                    totalMovements[newRow][newCol] += totalMovements[row][col] + 1;
//                    printTotalMoments(totalMovements);
                    query.add(newLoc);
                }
            }
        }


        return 999;
    }

    static int wandWave(int row, int col, int[][] totalMovements) {
        int[][] moves = new int[][] {
                {1,0}, {0,1}, {-1,0}, {0,-1},
        };
        int cnt = 0;
        while(true) {
            for(int[] move : moves) {
                if(isValidLocation(new int[] {row+move[0],col+move[1] })  && totalMovements[row+move[0]][col+move[1]] == totalMovements[row][col]-1) {
                    row = row+move[0];
                    col = col+move[1];
                    int cnt2 = 0;
                    for(int[] move2 : moves) {
                        if (isValidLocation(new int[] {row+move2[0],col+move2[1] }) && totalMovements[row+move2[0]][col+move2[1]] == totalMovements[row][col]+1) {
                            cnt2++;
                        }
                    }
                    if(cnt2 > 1) {
                        cnt++;
                    }
                }
            }
            if(totalMovements[row][col] == 1) break;
            if (totalMovements[row][col] == 0) break;
        }

        //System.out.println("Count is " + cnt);
        return cnt;
    }



    static boolean isValidLocation(int[] location) {
        int row = location[0];
        int col = location[1];
//        System.out.println(row);
//        System.out.println(col);

        if (row >= 0 && col >= 0 && row < N && col < M) {
//            System.out.println(row + " " + col + "x");
            return true;
        }
        return false;
    }



    static int[] findLocation(String[][] matrix) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(matrix[i][j].equals("M")) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            String[] matrix = new String[n];

            for (int i = 0; i < n; i++) {
                String matrixItem = scanner.nextLine();
                matrix[i] = matrixItem;
            }

            int k = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = countLuck(matrix, k);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
