package codes.java.graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {
    Stack<Integer> stack;
    int[] topologicalSorting(int[][] edges, int n) {
        stack = new Stack<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for(int[] edge : edges)
            graph.get(edge[0]).add(edge[1]);

        System.out.println(graph);

        int[] vis = new int[n];

        for(int i = 0; i < n; i++) {
            if(!dfs(graph, i, vis))
                return new int[0];
        }

        int[] ans = new int[n];
        for(int i = 0; i < n; i++)
            ans[i] = stack.pop();

        return ans;
    }

    boolean dfs(ArrayList<ArrayList<Integer>> graph, int s, int[] vis) {
        if(vis[s] == 2)
            return true;

        if(vis[s] == 1)
            return false;

        vis[s] = 1;
        for(int i : graph.get(s)) {
            if(!dfs(graph, i, vis))
                return false;
        }

        vis[s] = 2;
        stack.push(s);
        return true;
    }

    public static void main(String[] args) {
        TopologicalSorting obj = new TopologicalSorting();
        int[][] edges = {{1,0}, {1,2}, {1,4},{2,4},{3,5},{4,5}};
        int n = 6;
        int[] ans = obj.topologicalSorting(edges, n);

        for(int i: ans)
            System.out.print(i + " ");
    }
}
