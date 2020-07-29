package codes.java.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens2 {

    ArrayList<ArrayList<String>> ans;
    boolean cols[];
    boolean diagLR[];
    boolean diagRL[];

    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        cols = new boolean[n];
        diagLR = new boolean[2 * n - 1];
        diagRL = new boolean[2 * n - 1];
        char[][] board = new char[n][n];

        for(char[] row: board)
            Arrays.fill(row, '.');

        solve(board, 0, n);

        return ans;
    }

    void solve(char[][] board, int curr_row, int n)
    {
        if(curr_row == n)
        {
            ArrayList<String> rows = new ArrayList<>();
            for(char row[]: board)
                rows.add(String.valueOf(row));

            ans.add(rows);
            return;
        }

        for(int column = 0; column < n; column++)
        {
            if(cols[column] || diagLR[curr_row - column + n - 1] || diagRL[curr_row + column] )
                continue;

            cols[column] = true;
            diagLR[curr_row - column + n - 1] = true;
            diagRL[curr_row + column] = true;
            board[curr_row][column] = 'Q';

            solve(board, curr_row + 1, n);

            cols[column] = false;
            diagLR[curr_row - column + n - 1] = false;
            diagRL[curr_row + column] = false;
            board[curr_row][column] = '.';
        }
    }

    static void printAns(ArrayList<ArrayList<String>> ans)
    {
        for(ArrayList<String> rows: ans)
        {
            for(String row: rows)
                System.out.println(row);

            System.out.println("\n\n");
        }
    }
    public static void main(String[] ar)
    {
        ArrayList<ArrayList<String>> ans = new NQueens2().solveNQueens(4);
        printAns(ans);
    }
}
