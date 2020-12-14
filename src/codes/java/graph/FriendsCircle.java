package codes.java.graph;

// https://leetcode.com/problems/friend-circles/

public class FriendsCircle {

    int countFriendCircle(int[][] M)
    {
        int n = M.length;
        int[] parents = new int[n];

        for(int i = 0; i < n; i++)
            parents[i] = i;

        for(int i = 0; i < n; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                if(M[i][j] == 1)
                    union(i, j, parents);
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++)
        {
            if(parents[i] == i)
                ans++;
        }

        return ans;
    }

    void union(int u, int v, int[] parents)
    {
        int parU = find(u, parents);
        int parV = find(v, parents);

        if(parU != parV)
            parents[parU] = parV;
    }

    int find(int u, int[] parents)
    {
        while(u != parents[u])
            u = parents[u];

        return u;
    }


}
