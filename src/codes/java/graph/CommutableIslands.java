package codes.java.graph;

import java.util.Arrays;
import java.util.Comparator;

// https://www.interviewbit.com/problems/commutable-islands/

public class CommutableIslands {

    int find(int u, int[] parent)
    {
        while(u != parent[u])
            u = parent[u];

        return u;
    }

    void union(int u, int v, int[] parent)
    {
        int parU = find(u, parent);
        int parV = find(v, parent);

        if(parU == parV)
            return;

        parent[parU] = parV;
    }

    int minCost(int[][] edges, int n)
    {
        int minCost = 0;
        Arrays.sort(edges, Comparator.comparingInt(a->a[2]));
        int[] parents = new int[n + 1];
        for(int i = 0; i < n; i++)
            parents[i] = i;
        int countOfEdges = 0;
        for(int[] edge :edges)
        {
            if(find(edge[0], parents) == find(edge[1], parents))
                continue;

            union(edge[0], edge[1], parents);
            countOfEdges++;
            minCost += edge[2];
            if(countOfEdges == n - 1)
                return minCost;
        }
        return -1;
    }

}
