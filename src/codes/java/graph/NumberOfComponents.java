package codes.java.graph;

// https://leetcode.com/problems/number-of-operations-to-make-network-connected/

import java.util.ArrayList;

public class NumberOfComponents {

    //Union Find
    int makeConnected(int n, int[][] connections)
    {
        if(connections.length < n - 1)
            return -1;

        int components = n;
        int[] parents = new int[n];
        for(int i = 0; i < n; i++)
            parents[i] = i;
        for(int[] connection: connections)
        {
            if(find(connection[0], parents) == find(connection[1], parents))
                continue;

            union(connection[0], connection[1], parents);
            components--;
        }


        return components - 1;
    }

    int find(int u, int[] parents)
    {
        while(u != parents[u])
            u = parents[u];

        return u;
    }

    void union(int u, int v, int[] parents)
    {
        int parU = find(u, parents);
        int parV = find(v, parents);

        if(parU != parV)
            parents[parU] = parV;
    }

    // DFS
    public int makeConnected_DFS(int n, int[][] connections)
    {
        if(connections.length < n - 1)
            return -1;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for(int[] connection: connections)
        {
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(connection[0]);
        }

        int components = 0;
        boolean[] vis = new boolean[n];
        for(int v = 0; v < n; v++)
        {
            if(!vis[v])
            {
                dfs(v, vis, graph);
                components++;
            }
        }
        return components - 1;
    }

    void dfs(int v, boolean[] vis, ArrayList<ArrayList<Integer>> graph)
    {
        if(vis[v])
            return;

        vis[v] = true;

        for(int u: graph.get(v))
            dfs(u, vis, graph);
    }

}
