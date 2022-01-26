package codes.java.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tower {

    int[][] solve(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[m][n];

        Queue<int[]> bfs = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 'G') {
                    bfs.add(new int[]{i, j});
                    ans[i][j] = 0;
                } else {
                    if(matrix[i][j] == 'W')
                        ans[i][j] = -1;
                    else {
                        ans[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
        }

        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1},};
        int dis = 0;

        while (!bfs.isEmpty()) {
            int size = bfs.size();
            while(size -- > 0) {
                int[] curr = bfs.poll();
                for(int[] dir: dirs) {
                    assert curr != null;
                    int nextI = curr[0] + dir[0];
                    int nextJ = curr[1] + dir[1];

                    if(isValid(nextI, nextJ, matrix)) {
                        matrix[nextI][nextJ] = 'W';
                        ans[nextI][nextJ] = Math.min(ans[nextI][nextJ], dis + 1);
                        bfs.add(new int[]{nextI, nextJ});
                    }
                }
            }
            dis++;
        }
        return ans;
    }

    private boolean isValid(int nextI, int nextJ, char[][] matrix) {
        return nextI >= 0 && nextI < matrix.length && nextJ >= 0
                && nextJ < matrix[0].length && matrix[nextI][nextJ] == 'O';
    }

    public static void main(String[] args) throws IOException {

        int m, n;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        m = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());
        char[][] matrix = new char[m][n];

        for(int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < n; j++)
                matrix[i][j] = stringTokenizer.nextToken().charAt(0);
        }

        //matrix = {{'O', 'O', 'G', 'O'}, {'W', 'G', 'O', 'G'}, {'O', 'O', 'G', 'O'},};
        int[][] ans = new Tower().solve(matrix);

        for (int[] an : ans) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(an[j] + " ");
            }
            System.out.print("\n");
        }

    }

}
