package codes.java.maths;

import java.util.ArrayList;

public class Paralleogram {

    int[] findFourthPoint(ArrayList<ArrayList<Character>> board, int[][] diag)
    {
        int m = board.size();
        int n = board.get(0).size();
        int x3 = -1, y3 = -1;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board.get(i).get(j) == '+')
                {
                    if(i + 1 != diag[0][0] && j + 1 != diag[0][1] && i + 1 != diag[1][0] && j + 1 != diag[1][1])
                    {
                        x3 = i + 1;
                        y3 = j + 1;
                    }
                }
            }
        }

        return new int[]{diag[0][0] + diag[1][0] - x3, diag[0][1] + diag[1][1] - y3};
    }
}
