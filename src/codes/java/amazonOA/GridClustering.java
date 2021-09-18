package codes.java.amazonOA;

/*Grid Climbing: A grid with m rows and n columns is used to form a cluster of nodes.
If a point in the grid has a value of 1, then it represents a node.
Each node in the cluster has a level associated with it.
A node located in the ith row of the grid is a level i node.
Here are the rules for creating a cluster: Every node at level i connects to all the nodes at level k where k > i
and k is the first level after level i that contains at least 1 node.
When i reaches the last level in the grid, no more connections are possible.
Given such a grid, find the number of connections present in the cluster.
*/


import java.util.ArrayList;
import java.util.Arrays;

public class GridClustering {

    int gridClustering(int[][] grid) {
        int ans = 0;
        int m = grid.length;

        int[] onesCountInEachRow = new int[m];
        int i = 0;

        for(int[] row: grid) {
            onesCountInEachRow[i++] = Arrays.stream(row).sum();
        }

        i = 0;
        int j = 0;

        while(j < m) {
            if (onesCountInEachRow[j] != 0 && j != i) {
                ans += (onesCountInEachRow[i] * onesCountInEachRow[j]);
                i++;
            }
            if(onesCountInEachRow[i] == 0)
                i++;

            j++;
        }


        return ans;

    }

    int gridCluster(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        ArrayList<Integer> arr = new ArrayList<>();

        for(int[] row: grid) {
            int sum = Arrays.stream(row).sum();
            if(sum != 0)
                arr.add(sum);
        }

        for(int i = 0; i < arr.size() - 1; i++)
            ans += (arr.get(i) * arr.get(i + 1));


        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,1,1}, {0,1,0}, {0,1,0}, {1,1,0}};
        System.out.println(new GridClustering().gridClustering(grid));

        grid = new int[][]{{1,1,1}};
        System.out.println(new GridClustering().gridClustering(grid));

        grid = new int[][]{{0,0,0}, {1,1,0}};
        System.out.println(new GridClustering().gridClustering(grid));

        grid = new int[][]{{1,1,1}, {0,1,1}, {0,0,0}, {0,1,0}, {1,1,1}, {0,0,0}, {1,1,0}};
        System.out.println(new GridClustering().gridClustering(grid));
    }
}
