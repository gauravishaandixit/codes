package codes.java.graph;

public class FloodFill {

    void floodFill(int[][] board, int si, int sj, int newColor)
    {
        if(board[si][sj] == newColor)
            return;

        int origColor = board[si][sj];
        DFS(board, si, sj, newColor, origColor);

    }

    void DFS(int[][] board, int i, int j, int newColor, int origColor)
    {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != origColor)
            return;

        board[i][j] = newColor;

        DFS(board, i + 1, j, newColor, origColor);
        DFS(board, i - 1, j, newColor, origColor);
        DFS(board, i, j + 1, newColor, origColor);
        DFS(board, i, j - 1, newColor, origColor);
    }

}
