package codes.java.backtracking;

import java.sql.Time;

public class NQueens1 {
    int ans;
    boolean[] cols;
    boolean[] diagLR;
    boolean[] diagRL;
    public int totalNQueens(int n) {

        ans = 0;
        cols = new boolean[n];
        diagLR = new boolean[2 * n - 1];
        diagRL = new boolean[2 * n - 1];

        solve(0, n);

        return ans;
    }

    void solve(int curr_row, int n) {
        if(curr_row == n) {
            ans++;
            return;
        }

        for(int column = 0; column < n; column++) {
            // if a queen is already present in same column or diagonals
            if(cols[column] || diagLR[curr_row - column + n - 1] || diagRL[curr_row + column])
                continue;


            cols[column] = true;
            diagLR[curr_row - column + n - 1] = true;
            diagRL[curr_row + column] = true;

            solve(curr_row + 1, n);

            cols[column] = false;
            diagLR[curr_row - column + n - 1] = false;
            diagRL[curr_row + column] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new NQueens1().totalNQueens(4));
        System.out.println(new NQueens1().totalNQueens(5));
        System.out.println(new NQueens1().totalNQueens(50));
    }
}
