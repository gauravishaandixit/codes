package codes.java.graph;

// https://leetcode.com/problems/01-matrix/

import java.util.LinkedList;
import java.util.Queue;

// Multi Source BFS
public class Matrix01 {

    int[][] updateMatrix(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(matrix[i][j] == 0)
                {
                    q.add(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0},{0, 1},{0, -1}};
        while (!q.isEmpty())
        {
            int[] curr = q.poll();
            for(int[] dir: dirs)
            {
                int currI = curr[0] + dir[0];
                int currJ = curr[1] + dir[1];

                if(currI < 0 || currI >= m || currJ < 0 || currJ >= n || vis[currI][currJ])
                    continue;

                vis[currI][currJ] = true;
                matrix[currI][currJ] = matrix[curr[0]][curr[1]] + 1;
                q.add(new int[]{currI, currJ});
            }
        }

        return matrix;
    }


}
