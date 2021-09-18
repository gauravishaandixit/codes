package codes.java.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CycleUndirected {

    boolean isCyclicDFS(ArrayList<ArrayList<Integer>> list, int V) {
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++)
            if(!vis[i]) {
                if(isDFSCyclic(i, -1, list, vis)) {
                    return true;
                }
            }

        return false;
    }

    private boolean isDFSCyclic(int i, int parent, ArrayList<ArrayList<Integer>> list, boolean[] vis) {
        vis[i] = true;

        for(int neigh: list.get(i)) {
            if(!vis[neigh]) {
                if(isDFSCyclic(neigh, i, list, vis))
                    return true;
            } else {
                if(neigh != parent)
                    return true;
            }
        }

        return false;
    }

    boolean isCyclicBFS(ArrayList<ArrayList<Integer>> list, int V) {
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++)
            if(!vis[i]) {
                if(isBFSCyclic(i, -1, list, vis)) {
                    return true;
                }
            }

        return false;
    }

    private boolean isBFSCyclic(int i, int parent, ArrayList<ArrayList<Integer>> list, boolean[] vis) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, parent});
        vis[i] = true;

        while(!q.isEmpty()) {

            int[] curr = q.poll();
            for(int neigh: list.get(curr[0])) {
                if(!vis[neigh]) {
                    vis[neigh] = true;
                    q.add(new int[]{neigh, curr[0]});
                } else {
                    if(neigh != curr[1])
                        return true;
                }
            }
        }
        return false;
    }
}
