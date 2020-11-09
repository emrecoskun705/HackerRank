import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
//there is an hackerrank version of this code in here youcan only check for just 1 matrix
//you can find it in CountLuck2.java

/*
*  Explanation:
*   first of all we used depth first search to find the road to the '*'
*   then by reverse going we checked if there is two path for real path
*
* */
public class CountLuck {
    static Scanner scanner = new Scanner(System.in);

    static int N = scanner.nextInt();
    static int M = scanner.nextInt();
    static String[][] matrix = new String[N][M];
    public static void main(String[] args) {

        for(int i=0; i<N; i++) {
            String[] line = scanner.next().split("");
            matrix[i] = line;
        }
        int k = scanner.nextInt();
        int[] location = findLocation(matrix);
        int count = countLuck(matrix, k, location);
        if (count == k) {
            System.out.println("Impressed");
        } else {
            System.out.println("Oops!");
        }
//        System.out.println(count);
    }


    static int countLuck(String[][] matrix, int k, int[] location) {
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
//                    System.out.println();
//                    System.out.println();
//                    System.out.println();
//                    System.out.println();
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
//                    System.out.println("row: " + row + " col: " + col);
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
//            System.out.println(totalMovements[row][col]);
            if (totalMovements[row][col] == 1) break;
            if (totalMovements[row][col] == 0) break;
        }
        System.out.println("Count is " + cnt);
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

    static void printQuery(ArrayList<int[]> query) {
        for(int i=0; i<query.size(); i++) {
            System.out.print(Arrays.toString(query.get(i)) + " ");
        }
    }

    static void printIsValid(boolean[][] query) {
        for(int i=0; i<query.length; i++) {
            for (int j=0; j<query[0].length; j++) {
                System.out.print(query[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void printTotalMoments(int[][] query) {
        for(int i=0; i<query.length; i++) {
            for (int j=0; j<query[0].length; j++) {
                System.out.print(query[i][j] + " ");
            }
            System.out.println();
        }
    }

}
