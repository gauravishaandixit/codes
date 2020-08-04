package codes.java.graph;

public class WordSearch_1 {

    boolean searchWord(char[][] board, String word)
    {
        boolean[][] vis = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(!vis[i][j] && board[i][j] == word.charAt(0))
                {
                    if(dfs(board, i, j, 0, word, vis))
                        return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, int i, int j, int index, String word, boolean[][] vis)
    {
        if(index == board.length)
            return true;

        boolean res = false;
        if(isSafe(board, i, j, vis) && word.charAt(index) == board[i][j])
        {
            vis[i][j] = false;

            res |= dfs(board, i + 1, j, index + 1, word, vis);
            res |= dfs(board, i - 1, j, index + 1, word, vis);
            res |= dfs(board, i, j + 1, index + 1, word, vis);
            res |= dfs(board, i, j - 1, index + 1, word, vis);

            vis[i][j] = true;
        }
        return res;
    }

    boolean isSafe(char[][] board, int i, int j, boolean[][] vis)
    {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || vis[i][j])
            return false;
        return true;
    }

    /// if question says that we can reuse cell, just remove the vis array
}
