package codes.java.graph;

import java.util.ArrayList;

public class CycleDirected {

    boolean isCyclic(ArrayList<ArrayList<Integer>> graph, int V)
    {
        int[] vis = new int[V];
        for(int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfs(graph, vis, i)) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean dfs(ArrayList<ArrayList<Integer>> graph,int[] vis,int i)
    {
        vis[i] = 1;
        for(int j : graph.get(i)) {
            if(vis[j] == 0) {
                if(dfs(graph, vis, j))
                    return true;
            }
            else {
                if(vis[j] == 1)
                    return true;
            }
        }

        vis[i] = 2;
        return false;
    }

}

