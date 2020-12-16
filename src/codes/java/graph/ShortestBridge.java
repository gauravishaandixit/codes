package codes.java.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

    int shortestBridge(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean firstIslandFound = false;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(matrix[i][j] == 1)
                {
                    dfs(matrix, i, j, q);
                    firstIslandFound = true;
                    break;
                }
            }

            if(firstIslandFound)
                break;
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int bridgeLength = 0;

        while(!q.isEmpty())
        {
            int size = q.size();
            while(size -- > 0)
            {
                int[] curr = q.poll();
                for(int[] dir: dirs)
                {
                    int i = curr[0] + dir[0];
                    int j = curr[1] + dir[1];


                    if(i >= 0 && j >= 0 && i < m && j < n)
                    {
                        if(matrix[i][j] == 1)
                            return bridgeLength;

                        if(matrix[i][j] == 0)
                        {
                            matrix[i][j] = 2;
                            q.add(new int[]{i, j});
                        }
                    }
                }
            }
            bridgeLength++;
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
