package codes.java.backtracking;

public class SudokuSolver {
    int rows, columns;

    public void solveSudoku(char[][] board) {

        rows = columns = 9;

        doBacktrack(board, 0, 0);

    }

    boolean doBacktrack(char[][] board, int curr_row, int curr_column)
    {

        if(curr_column == columns)
            return doBacktrack(board, curr_row + 1, 0);

        if(curr_row ==  rows)
            return true;

        if(board[curr_row][curr_column] != '.')
            return doBacktrack(board, curr_row, curr_column + 1);


        for(char curr = '1'; curr <= '9'; curr++ )
        {
            if(isValid(board, curr_row, curr_column, curr))
            {
                board[curr_row][curr_column] = curr;

                if(doBacktrack(board, curr_row, curr_column + 1))
                    return true;

                board[curr_row][curr_column] = '.';
            }
        }

        return false;
    }

    boolean isValid(char[][] board, int curr_row, int curr_column, char curr)
    {
        int regionRow = 3 * (curr_row / 3);  //region start row

        int regionCol = 3 * (curr_column / 3);    //region start col

        for (int i = 0; i < 9; i++)
        {
            if (board[i][curr_column] == curr) return false; //check row

            if (board[curr_row][i] == curr) return false; //check column

            if (board[regionRow + i / 3][regionCol + i % 3] == curr) return false; //check 3*3 block
        }

        return true;
    }
}
