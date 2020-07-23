package codes.java.graph;

public class UnionFind {
    void union(int u, int v, int[] parents)
    {
        int parU = find(u, parents);
        int parV = find(v, parents);

        if(parU == parV)
            return;

        parents[parU] = parV;
        //parents[parV] = parU; //also correct
    }

    int find(int u, int[] parents)
    {
        while(u != parents[u])
            u = parents[u];

        return u;
    }



}
