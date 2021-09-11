package codes.java.graph;

import java.util.Arrays;
import java.util.HashMap;

public class BellmanFord {

    int[] singleSourceShortestPath(int[][] edges, int n, int start)
    {
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();

        for(int[] edge: edges) {
            graph.computeIfAbsent(edge[0], k -> new HashMap<>()).put(edge[1], edge[2]);
            graph.computeIfAbsent(edge[1], k -> new HashMap<>()).put(edge[0], edge[2]);
        }

        dis[start] = 0;

        for(int i = 0; i < n - 1; i++) {
            for(int u : graph.keySet()) {
                for(int v: graph.get(u).keySet()) {
                    if(dis[u] != Integer.MAX_VALUE && dis[u] + graph.get(u).get(v) < dis[v])
                        dis[v] = dis[u] + graph.get(u).get(v);
                }
            }
        }
        return dis;
    }

    public static void main(String[] ar)
    {
        int[][] edges = {{1,0,1},{1,2,1},{2,3,1}};
        int n = 4;
        int start = 2;

        int[] ans = new BellmanFord().singleSourceShortestPath(edges, n, start);

        for(int i = 0; i < n ;i++)
            System.out.print(ans[i] + " ");

        System.out.print("\n");
    }
}
