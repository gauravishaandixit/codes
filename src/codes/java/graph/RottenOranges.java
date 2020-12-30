package codes.java.graph;

// https://leetcode.com/problems/rotting-oranges/

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    class Rotten
    {
        int i, j;
        Rotten(int i, int j)
        {
            this.i = i;
            this.j = j;
        }
    }

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int freshOranges = 0;

        Queue<Rotten> q = new LinkedList<>();

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 2)
                    q.add(new Rotten(i, j));
                else
                if(grid[i][j] == 1)
                    freshOranges++;
            }
        }

        //System.out.println(freshOranges);

        if(freshOranges == 0)
            return 0;



        int time = 0;

        int x[] = {-1, 1, 0, 0};
        int y[] = {0, 0, 1, -1};

        while(!q.isEmpty())
        {
            int size = q.size();
            while(size-- > 0)
            {
                Rotten currOrange = q.poll();
                for(int i = 0; i < 4; i++)
                {
                    int nextI = currOrange.i + x[i];
                    int nextJ = currOrange.j + y[i];

                    if(isValid(grid, nextI, nextJ))
                    {
                        grid[nextI][nextJ] = 2;
                        q.add(new Rotten(nextI, nextJ));
                        freshOranges--;
                    }
                }
            }
            time++;
        }

        return freshOranges == 0 ? time - 1 : -1;
    }

    boolean isValid(int[][] grid, int i, int j)
    {
        int m = grid.length, n = grid[0].length;

        return i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1;
    }
}
