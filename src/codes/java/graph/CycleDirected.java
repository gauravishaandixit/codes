package codes.java.graph;

import java.util.ArrayList;

public class CycleDirected {

    boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
        int[] vis = new int[V];
        boolean flag = false;
        for(int i = 0; i < V; i++)
            if(vis[i] == 0)
                flag |= dfs(list,vis,i);

        return flag;
    }

    static boolean dfs(ArrayList<ArrayList<Integer>> list,int[] vis,int i)
    {
        ArrayList<Integer> arr = list.get(i);
        vis[i] = 1;
        boolean flag = false;
        for(int j : arr)
        {
            if(vis[j] == 0)
                flag |= dfs(list,vis,j);
            else
            {
                if(vis[j] == 1)
                    flag |= true;
            }
        }

        vis[i] = 2;
        return flag;
    }

}
