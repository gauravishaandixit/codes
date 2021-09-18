package codes.java.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

    boolean isBipartiteBFS(ArrayList<ArrayList<Integer>> graph, int V) {

        int[] color = new int[V];
        Arrays.fill(color, -1);

        for(int i = 0; i < V; i++) {
            if(color[i] == -1) {
                if(!isBipartiteBFS(i, graph, color))
                    return false;
            }
        }

        return true;
    }

    private boolean isBipartiteBFS(int i, ArrayList<ArrayList<Integer>> graph, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        color[i] = 1;
        q.add(i);

        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int neigh: graph.get(curr)) {
                if(color[neigh] == -1) {
                    color[neigh] = 1 - color[curr];
                    q.add(neigh);
                } else {
                    if(color[neigh] == color[curr])
                        return false;
                }
            }
        }
        return true;
    }

    boolean isBipartiteDFS(ArrayList<ArrayList<Integer>> graph, int V) {

        int[] color = new int[V];
        Arrays.fill(color, -1);

        for(int i = 0; i < V; i++) {
            if(color[i] == -1) {
                if(!isBipartiteDFS(i, graph, color))
                    return false;
            }
        }

        return true;
    }

    private boolean isBipartiteDFS(int i, ArrayList<ArrayList<Integer>> graph, int[] color) {
        if(color[i] == -1) {
            color[i] = 1;
        }

        for(int neigh: graph.get(i)) {
            if(color[neigh] == -1) {
                color[neigh] = 1 - color[i];
                if(!isBipartiteDFS(neigh, graph, color))
                    return false;
            } else {
                if(color[neigh] == color[i])
                    return false;
            }
        }

        return true;
    }

}
