package codes.java.graph;

import java.util.ArrayList;

public class DFS {

    void printDFS(int n, int[][] edges)
    {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for(int[] edge: edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int v = 0; v < n; v++)
        {
            if(!vis[v])
            {
                dfs(v,vis, graph, ans);
            }
        }
        System.out.println(ans);

    }

    void dfs(int u, boolean[] vis, ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> ans)
    {
        if(vis[u])
            return;

        vis[u] = true;
        ans.add(u);
        for(int v: graph.get(u))
            dfs(v, vis, graph, ans);
    }


    public static void main(String[] args)
    {
        DFS obj = new DFS();
        int[][] edges = {{0, 1}, {3, 2},{1, 3},{5, 6}, {7,8}, {5,8}};
        int n = 10;

        obj.printDFS(n, edges);
    }


}
