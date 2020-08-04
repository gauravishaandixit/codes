package codes.java.graph;

public class CountIslands {

    int countIslands(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        boolean[][] vis = new boolean[m][n];

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(!vis[i][j] && matrix[i][j] == 1)
                {
                    dfs(matrix, i, j, vis);
                    ans++;
                }
            }
        }

        return ans;
    }

    void dfs(int[][] matrix, int i, int j, boolean[][] vis)
    {
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || vis[i][j] || matrix[i][j] != 1)
            return;

        vis[i][j] = true;

        dfs(matrix, i + 1, j, vis);
        dfs(matrix, i - 1, j, vis);
        dfs(matrix, i, j - 1, vis);
        dfs(matrix, i, j + 1, vis);
    }
}
