package codes.java.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

    int shortestBridge(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean firstIsland = false;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(matrix[i][j] == 1)
                {
                    dfs(matrix, i, j, q);
                    firstIsland = true;
                    break;
                }
            }

            if(firstIsland)
                break;
        }

        int lengthBridge = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty())
        {
            int[] curr = q.poll();

            for(int[] dir: dirs)
            {
                int nextI = curr[0] + dir[0];
                int nextJ = curr[1] + dir[1];

                if(nextI < 0 || nextJ < 0 || nextI >= m || nextJ >= n || matrix[nextI][nextJ] == 2)
                    continue;

                if(matrix[nextI][nextJ] == 1)
                    return lengthBridge;

                matrix[nextI][nextJ] = 2;

                q.add(new int[]{nextI, nextJ});
            }
            lengthBridge++;
        }
        return -1;
    }

    void dfs(int[][] matrix, int i, int j, Queue<int[]> q)
    {
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] != 1)
            return;

        q.add(new int[]{i, j});
        matrix[i][j] = 2;

        dfs(matrix, i + 1, j, q);
        dfs(matrix, i - 1, j, q);
        dfs(matrix, i, j + 1, q);
        dfs(matrix, i, j - 1, q);
    }
}
