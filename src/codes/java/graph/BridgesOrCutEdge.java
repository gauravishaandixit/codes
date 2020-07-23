package codes.java.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgesOrCutEdge {

    List<List<Integer>> ans;
    int[] ids, low;
    boolean vis[];
    int id;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for(List<Integer> connection: connections)
        {
            graph.get(connection.get(0)).add(connection.get(1));
            graph.get(connection.get(1)).add(connection.get(0));
        }

        ans = new ArrayList<>();
        ids = new int[n];
        vis = new boolean[n];
        Arrays.fill(ids, -1);
        low = new int[n];
        id = 0;

        dfs(0, -1, graph);

        return ans;
    }

    void dfs(int curr, int parent, ArrayList<ArrayList<Integer>> graph)
    {
        vis[curr] = true;
        id++;
        low[curr] = ids[curr] = id;


        for(int neigh: graph.get(curr))
        {
            if(neigh == parent)
                continue;

            if(!vis[neigh])
            {
                dfs(neigh, curr, graph);
                low[curr] = Math.min(low[curr], low[neigh]);

                if(ids[curr] < low[neigh])
                    ans.add(Arrays.asList(curr, neigh));
            }
            else
                low[curr] = Math.min(low[curr], ids[neigh]);
        }
    }
}

/*
//BruteForce:: TLE
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for(List<Integer> connection: connections)
        {
            graph.get(connection.get(0)).add(connection.get(1));
            graph.get(connection.get(1)).add(connection.get(0));
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(List<Integer> connection: connections)
        {
            int x = connection.get(0);
            int y = connection.get(1);

            HashSet<Integer> visited = new HashSet<>();

            graph.get(x).remove(new Integer(y));
            graph.get(y).remove(new Integer(x));

            dfs(graph, 1, visited);

            if(visited.size() != n)
                ans.add(Arrays.asList(x,y));


            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        return ans;
    }

    void dfs(ArrayList<ArrayList<Integer>> graph, int source, HashSet<Integer> visited)
    {
        visited.add(source);

        for(int v : graph.get(source))
            if(!visited.contains(v))
                dfs(graph, v, visited);
    }
}*/
