package codes.java.graph;

import java.util.Arrays;
import java.util.HashMap;

public class FloydWarshall {
    int[][] allPairShortestPath(int[][] edges, int n) {

        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new HashMap<>()).put(edge[1], edge[2]);
            graph.computeIfAbsent(edge[1], k -> new HashMap<>()).put(edge[0], edge[2]);
        }

        int dis[][] = new int[n][n];
        for(int d[] : dis)
            Arrays.fill(d, Integer.MAX_VALUE);
        for(int u : graph.keySet())
        {
            for(int v: graph.get(u).keySet())
            {
                dis[u][v] = graph.get(u).get(v);
            }
        }

        for(int k = 0; k < n; k++)
        {
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }
        return dis;
    }
}
