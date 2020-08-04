package codes.java.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CycleUndirected {

    boolean isCyclic(ArrayList<ArrayList<Integer>> graph, int V)
    {
        boolean[] vis = new boolean[V];

        for(int i = 0; i < V; i++)
        {
            if(!vis[i])
            {
                if(isCyclicUtil(graph, i, -1, vis))
                    return true;
            }
        }
        return false;
    }

    boolean isCyclicUtil(ArrayList<ArrayList<Integer>> graph, int u, int p, boolean[] vis)
    {
        vis[u] = true;

        for(int v: graph.get(u))
        {
            if(!vis[v])
            {
                if(isCyclicUtil(graph, v, u, vis))
                    return true;
            }
            else
            {
                if(v != p)
                    return true;
            }
        }
        return false;
    }

    boolean isCyclicBFS(ArrayList<ArrayList<Integer>> graph, int V)
    {
        boolean[] vis = new boolean[V];

        for(int i = 0; i < V; i++)
        {
            if(!vis[i])
            {
                if(isCyclicUtilBFS(graph, i, vis))
                    return true;
            }
        }
        return false;
    }

    boolean isCyclicUtilBFS(ArrayList<ArrayList<Integer>> graph, int u, boolean[] vis)
    {
        int[] parent = new int[graph.size()];
        Arrays.fill(parent, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        vis[u] = true;
        while (!q.isEmpty())
        {
            int curr = q.poll();
            for(int v : graph.get(curr))
            {
                if(!vis[v])
                {
                    vis[v] = true;
                    q.add(v);
                    parent[v] = u;
                }
                else
                    if(parent[u] != v)
                        return true;
            }
        }

        return false;
    }

}
