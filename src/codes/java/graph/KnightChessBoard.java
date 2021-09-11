package codes.java.graph;

import java.util.LinkedList;
import java.util.Queue;

public class KnightChessBoard {

    static class Cell
    {
        int x, y, dis;
        Cell(int x, int y, int dis)
        {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    public int knight(int m, int n, int Sx, int Sy, int Tx, int Ty) {

        int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        boolean[][] vis = new boolean[m + 1][n + 1];
        Queue<Cell> q=new LinkedList<>();

        q.add(new Cell(Sx, Sy, 0));
        vis[Sx][Sy] = true;
        int distance = -1;

        while(!q.isEmpty()) {

            Cell t = q.poll();
            if(t.x == Tx && t.y == Ty) {
                distance = t.dis;
                break;
            }

            for(int i = 0; i < 8; i++) {
                int x = t.x + dx[i];
                int y = t.y + dy[i];

                if(isValid(x, y, m, n) && !vis[x][y]) {
                    vis[x][y] = true;
                    q.add(new Cell(x, y, t.dis + 1));
                }
            }
        }

        return distance;
    }
    boolean isValid(int x, int y, int m, int n) {
        return x >= 1 && x <= m && y >= 1 && y <= n;
    }
}
