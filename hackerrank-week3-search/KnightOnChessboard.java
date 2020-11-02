import java.util.*;

public class KnightOnChessboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 5;
        int[][] arr = new int[n-1][n-1];


        for(int i=1; i<n; i++) {
            for(int j=i; j<n; j++) {
                // movements method calculates the total attempt to reach the bottom right square
                arr[i-1][j-1] = movemnets(i, j, n);
                arr[j-1][i-1] =arr[i-1][j-1];

            }
        }

        scanner.close();
    }

    public static int movemnets(int i, int j, int n) {
        int[][] totalMovements = new int[n][n];
        int[][] isValid = new int[n][n];
        isValid[0][0] = 1;
        // we will add all possible location step by step in this query
        List<ArrayList<Integer>> query = new ArrayList<>();

        //initial location is (0,0) so we must add it firstly
        ArrayList<Integer> initialLocation = new ArrayList<>();
        initialLocation.add(0);initialLocation.add(0);
        query.add(initialLocation);

        //possible movements
        int[][] possibleMovements = new int[][] {
                {i, j}, {j, i}, {-i, j},
                {-j, i}, {j, -i}, {i, -j},
                {-i, -j}, {-j, -i}
        };

        // we will delete all the queries when we find for it's possible locations
        while (!query.isEmpty()) {
            int a = query.get(0).get(0);
            int b = query.get(0).get(1);
            query.remove(0);
            if(a == n-1 && b == n-1) {
                return totalMovements[n-1][n-1];//TODO:update this return with distance
            }

            for(int[] movement : possibleMovements) {
                int x = movement[0];
                int y = movement[1];

                if(a+x >= 0 && a+x < n && b+y >= 0 && b+y < n && isValid[a+x][b+y] == 0) {
                    isValid[a+x][b+y] = 1;
                    ArrayList<Integer> arrList = new ArrayList<>();
                    arrList.add(a+x);
                    arrList.add(b+y);
                    query.add(arrList);
                    totalMovements[a+x][b+y] = totalMovements[a][b] + 1;
                }
            }
        }

        return -1;
    }
















// another solution

    static int[][] knightlOnAChessboard(int n) {
        int[][] ret = new int[n - 1][n - 1];

        for (int r = 1; r < n; r++) {
            for (int c = 1; c < n; c++) {
                if (ret[c - 1][r - 1] != 0) {
                    ret[r-1][c-1] = ret[c-1][r-1];
                    continue;
                }
                if (ret[r-1][c-1] == 0) {
                    ret[r-1][c-1] = move(n, r, c);
                }
            }
        }
        return ret;
    }

    static int move(int n, int a, int b) {
        int[][] dirs = {{a, b}, {-a, -b}, {a, -b}, {-a, b},  {b, a}, {-b, -a}, {b, -a}, {-b, a}};

        boolean[][] visited = new boolean[n][n];
        int[][] dist = new int[n][n];

        int er = n - 1;
        int ec = n - 1;
        for (int[] row: dist) {
            Arrays.fill(row, - 1);
        }

        visited[0][0] = true;
        dist[0][0] = 0;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.remove();
            if (cur[0] == er && cur[1] == ec) {
                return dist[er][ec];
            }

            for(int[] dir: dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];

                if (x >= 0 && y >= 0 && x < n && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    q.add(new int[]{x, y});
                    dist[x][y] = dist[cur[0]][cur[1]] + 1;
                }
            }
        }

        return -1;
    }
}
