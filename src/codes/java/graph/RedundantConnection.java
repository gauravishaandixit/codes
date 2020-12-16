package codes.java.graph;

public class RedundantConnection {

    int[] findRedundantConnection(int[][] edges)
    {
        int[] parents = new int[edges.length + 1];
        for(int[] edge: edges)
        {
            int u = find(edge[0], parents);
            int v = find(edge[1], parents);

            if(u == v)
                return edge;

            parents[u] = v;
        }

        return new int[]{};
    }

    int find(int u, int[] parents)
    {
        if(parents[u] == 0)
            return u;

        return parents[u] = find(parents[u], parents);
    }


}
