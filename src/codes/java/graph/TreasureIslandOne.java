package codes.java.graph;

import java.util.*;

/*
* You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs.
* Other areas are safe to sail in. There are other explorers trying to find the treasure.
* So you must figure out a shortest route to the treasure island.

Assume the map area is a two dimensional grid, represented by a matrix of characters.
* You must start from the top-left corner of the map and can move one block up, down, left or right at a time.
* The treasure island is marked as X in a block of the matrix. X will not be at the top-left corner.
* Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks.
* You cannot leave the map area. Other areas O are safe to sail in.
* The top-left corner is always safe. Output the minimum number of steps to get to the treasure.
*
*
*
* */
public class TreasureIslandOne {

    private int distance = Integer.MAX_VALUE;

    public int findShortestRoute(char[][] island) {
        if (island == null) {
            return -1;
        }
        boolean[][] visited = new boolean[island.length][island[0].length];
        dfs(island, 0, 0, visited, 0);

        return distance;
    }

    public void dfs(char[][] grid, int i, int j, boolean[][] visited, int levelDistance) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 'D' || visited[i][j]) {
            return;
        }
        if (grid[i][j] == 'X') {
            distance = Math.min(distance, levelDistance);
            return;
        }
        visited[i][j] = true;

        dfs(grid, i, j - 1, visited, levelDistance + 1); // back
        dfs(grid, i - 1, j, visited, levelDistance + 1);// up
        dfs(grid, i, j + 1, visited, levelDistance + 1);// forward
        dfs(grid, i + 1, j, visited, levelDistance + 1);// downward

        visited[i][j] = false;
    }

    public static void main(String[] args) {
        TreasureIslandOne obj = new TreasureIslandOne();
        char[][] input = {{'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'X', 'O', 'O', 'O'},
                {'O', 'D', 'D', 'O'}};

        System.out.println(obj.findShortestRoute(input));

    }

    public static int treasureIsland(char[][] island) {
        if (island == null || island.length == 0) return 0;

        int steps = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(0, 0));
        boolean[][] visited = new boolean[island.length][island[0].length];
        visited[0][0] = true;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // bfs
        while (!queue.isEmpty()) {

            int size = ((LinkedList) queue).size();
            for (int i = 0; i < size; i++) {
                Coordinate coordinate = queue.poll();
                int x = coordinate.x;
                int y = coordinate.y;
                if (island[x][y] == 'X') return steps;

                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length &&
                            island[newX][newY] != 'D' && !visited[newX][newY]) {
                        queue.add(new Coordinate(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
            steps++;
        }

        return 0;
    }
    static class Coordinate
    {
        int x;
        int y;

        Coordinate(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}