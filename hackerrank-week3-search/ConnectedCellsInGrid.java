import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedCellsInGrid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] matrix = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }




        boolean[][] isVisited = new boolean[n][m];

        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == 0) continue;
                if(isVisited[i][j]) continue;
                int[][] visitedLocations = calculate(i,j,matrix);
                //System.out.println("len: " + visitedLocations.length);
                max = Math.max(max, visitedLocations.length);
                for(int[] location : visitedLocations) {
                    isVisited[location[0]][location[1]] = true;

                }
            }
        }


        System.out.println(max);
    }


    /*This method finds us the maximum road(positions which are side by side with value of 1) for the given x and y*/
    public static int[][] calculate(int x, int y, int[][] arr) {
        int[][] movements = {
                {1,1}, {-1,-1}, {1,-1}, {-1,1}, {1,0}, {0,1}, {-1,0}, {0,-1}
        };

        int n = arr.length;
        int m = arr[0].length;

        boolean[][] isVisited = new boolean[n][m];
        ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();

        //we will add this query every possible locations until there is no location
        //but we will be careful about Have we been in that position before (isVisited)
        ArrayList<ArrayList<Integer>> query = new ArrayList<>();
        ArrayList<Integer> initial = new ArrayList<>();
        initial.add(x);
        initial.add(y);
        query.add(initial);

        // we added first position to list and we changed the value of initial position to true
        //because we already in that position
        arrList.add(initial);
        isVisited[x][y] = true;



        while(!query.isEmpty()) {

            int row = query.get(0).get(0);
            int col = query.get(0).get(1);
            //System.out.println(row + " "+ col);
            query.remove(0);


            for(int[] movement : movements) {
                int newX = row + movement[0];
                int newY = col + movement[1];

                if(newX >= 0 && newY >= 0 && newX < n && newY < m && !isVisited[newX][newY] && arr[newX][newY] == 1) {
                    ArrayList<Integer> pos = new ArrayList<>();
                    pos.add(newX);
                    pos.add(newY);
                    System.out.println(pos);
                    isVisited[newX][newY] = true;
                    query.add(pos);
                    arrList.add(pos);


                }
            }
        }


        //TO ARRAY
        int[][] arrAnswer = new int[arrList.size()][2];
        for(int i=0; i<arrList.size(); i++) {
            for(int j=0; j<2; j++) {
                arrAnswer[i][j] = arrList.get(i).get(j);
            }
        }

        return arrAnswer;

    }
}
