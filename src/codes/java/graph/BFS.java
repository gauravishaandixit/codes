package codes.java.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    ArrayList<Integer> bfsOrder;
    ArrayList<Integer> BFSOrder(int[][] edges, int n)
    {
        bfsOrder = new ArrayList<>();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for(int edge[] : edges)
        {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean vis[] = new boolean[n];

        for(int i = 0; i < n ;i++)
        {
            if(!vis[i])
            {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);

                while(!q.isEmpty())
                {
                    int curr = q.poll();
                    bfsOrder.add(curr);
                    vis[curr] = true;
                    for(int neigh: graph.get(curr))
                    {
                        if(!vis[neigh])
                            q.add(neigh);
                    }
                }
            }
        }
        return bfsOrder;
    }

    public static void main(String args[])
    {
        BFS obj = new BFS();
        int edges[][] = {{0, 1}, {3, 2},{1, 3},{5, 6}, {7,8}, {5,8}};
        int n = 10;

        System.out.println(obj.BFSOrder(edges, n));
    }
}
