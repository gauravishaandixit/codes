package codes.java.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraAlgorithm
{
    int[] shortestPath(int n, int[][] edges, int start)
    {
        int ans[] = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();

        for(int[] edge: edges)
        {
            graph.computeIfAbsent(edge[0], k -> new HashMap<>()).put(edge[1], edge[2]);
            graph.computeIfAbsent(edge[1], k -> new HashMap<>()).put(edge[0], edge[2]);
        }

        boolean vis[] = new boolean[n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.add(new int[]{start, 0});
        ans[start] = 0;

        while(!minHeap.isEmpty())
        {
            int[] curr = minHeap.poll();
            if(vis[curr[0]]) continue;

            vis[curr[0]] = true;
            ans[curr[0]] = curr[1];

            if(!graph.containsKey(curr[0])) continue;
            for(int neigh: graph.get(curr[0]).keySet())
            {
                int weight = graph.get(curr[0]).get(neigh);
                if(!vis[neigh] && ans[neigh] > ans[curr[0]] + weight)
                {
                    ans[neigh] = ans[curr[0]] + weight;
                    minHeap.add(new int[]{neigh, ans[neigh]});
                }
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        DijkstraAlgorithm obj = new DijkstraAlgorithm();
        int[][] edges = {{1,0,1},{1,2,1},{2,3,1}};
        int n = 4;
        int start = 2;

        int res[] = obj.shortestPath(n, edges, start);

        for(int i = 0; i < n ;i++)
            System.out.print(res[i] + " ");

        System.out.print("\n");
    }
}
