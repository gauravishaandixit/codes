package codes.java.takeUForward;

public class SearchIn2DMatrix {
    // GFG Version
    boolean searchGFG(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;

        while(i < m && j >= 0) {
            if(matrix[i][j] == target)
                return true;
            if(matrix[i][j] < target)
                i++;
            else
                j--;
        }
        return false;
    }

    // Leetcode version
    boolean searchLeetcode(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0, high = m * n - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            int row = mid % n;
            int col = mid / n;

            if(matrix[row][col] == target)
                return true;

            if(matrix[row][col] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return false;
    }
}
