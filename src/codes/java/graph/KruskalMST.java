package codes.java.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class KruskalMST {

    static class Edge
    {
        int u, v, weight;
        Edge(int u, int v, int weight)
        {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        public String toString()
        {
            return u + " " + v + " " + weight;
        }
    }
    ArrayList<Edge> mstEdges;
    int connectedComponents;
    void union(int u, int v, int[] parents)
    {
        int parU = find(u, parents);
        int parV = find(v, parents);

        if(parU == parV)
            return;
        connectedComponents--;
        //parents[parU] = parV;
        parents[parV] = parU; //also correct
    }

    int find(int u, int[] parents)
    {
        while(u != parents[u])
            u = parents[u];

        return u;
    }


    int KruskalAlgorithm(int n, int[][] edges)
    {
        int minCost = 0;
        mstEdges = new ArrayList<>();
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));
        int[] parents = new int[n];
        for(int i = 0; i < n; i++)
            parents[i] = i;
        connectedComponents = n;
        for(int[] edge : edges)
        {
            if(find(edge[0], parents) == find(edge[1], parents))
                continue;
            union(edge[0], edge[1], parents);
            minCost += edge[2];
            mstEdges.add(new Edge(edge[0], edge[1], edge[2]));

            if(connectedComponents == 1)
                return minCost;
        }
        mstEdges.clear();
        return -1;
    }
    public static void main(String[] args)
    {
        KruskalMST obj = new KruskalMST();
        int n = 8;
        int[][] edges = new int[][]{{0,1,3}, {0,2,1}, {1,2,1},{2,3,5},{3,4,2},{3,7,8},{4,5,3},{5,6,6},{6,7,4},{5,7,1},{3,5,1}};
        System.out.println("Weight of MST is:: " + obj.KruskalAlgorithm(n, edges));
        System.out.println("Edges of MST are:: ");
        System.out.println(obj.mstEdges);

        obj.mstEdges.clear();

        n = 10;
        edges = new int[][]{{0,1,3}, {0,2,1}, {1,2,1},{2,3,5},{3,4,2},{3,7,8},{4,5,3},{5,6,6},{6,7,4},{5,7,1},{3,5,1},{8, 9, 5}};
        System.out.println("\nWeight of MST is:: " + obj.KruskalAlgorithm(n, edges));
        System.out.println("Edges of MST are:: ");
        System.out.println(obj.mstEdges);

    }
}
