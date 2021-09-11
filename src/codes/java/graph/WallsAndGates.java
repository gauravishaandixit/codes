package codes.java.graph;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    void wallsAndGateBFS(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0)
                    q.add(new int[]{i, j, 0});
            }
        }

        int[][] dir = new int[][]{ {1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty()) {

            int size = q.size();
            while(size-- > 0) {
                int[] curr = q.poll();

                matrix[curr[0]][curr[1]] = curr[2];

               int x = curr[0] + 1;
               int y = curr[1];

               if(isValid(x, y, matrix)) {
                   matrix[x][y] = curr[2] + 1;
                   q.add(new int[]{x, y, matrix[x][y]});
               }


                x = curr[0] - 1;
                y = curr[1];

                if(isValid(x, y, matrix)) {
                    matrix[x][y] = curr[2] + 1;
                    q.add(new int[]{x, y, matrix[x][y]});
                }

                x = curr[0];
                y = curr[1] + 1;

                if(isValid(x, y, matrix)) {
                    matrix[x][y] = curr[2] + 1;
                    q.add(new int[]{x, y, matrix[x][y]});
                }

                x = curr[0];
                y = curr[1] - 1;

                if(isValid(x, y, matrix)) {
                    matrix[x][y] = curr[2] + 1;
                    q.add(new int[]{x, y, matrix[x][y]});
                }
            }
        }

    }

    void wallsAndGateDFS(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0)
                    dfs(i, j, matrix, 0);
            }
        }
    }

    private void dfs(int i, int j, int[][] matrix, int distance) {
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] < distance)
            return;

        matrix[i][j] = distance;

        dfs(i + 1, j, matrix, distance + 1);
        dfs(i - 1, j, matrix, distance + 1);
        dfs(i, j + 1, matrix, distance + 1);
        dfs(i, j - 1, matrix, distance + 1);
    }

    boolean isValid(int x, int y, int[][] matrix) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] == Integer.MAX_VALUE;
    }

    static void printArray(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        int[][] matrix =  {{Integer.MAX_VALUE ,-1, 0, Integer.MAX_VALUE},
                           {Integer.MAX_VALUE ,Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                           {Integer.MAX_VALUE ,-1, Integer.MAX_VALUE, -1},
                           {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}};

        new WallsAndGates().wallsAndGateBFS(matrix);

        printArray(matrix);

        System.out.println("\n");

        matrix = new int[][] {{Integer.MAX_VALUE ,-1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE ,Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE ,-1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}};

        new WallsAndGates().wallsAndGateDFS(matrix);

        printArray(matrix);

    }

}
