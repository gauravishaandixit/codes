package codes.java.tree;

import java.util.*;

public class FarthestNodeFromEachNode {

    ArrayList<Integer> farthestNodeFromEachNode(int[] tree)
    {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < tree.length; i++)
            graph.add(new ArrayList<>());

        for(int i = 0; i < tree.length; i++)
        {
            if(tree[i] == 1)
            {
                int v1 = 2 * i + 1;
                int v2 = 2 * i + 2;

                if(v1 < tree.length && tree[v1] == 1)
                {
                    graph.get(i).add(v1);
                    graph.get(v1).add(i);
                }

                if(v2 < tree.length && tree[v2] == 1)
                {
                    graph.get(i).add(v2);
                    graph.get(v2).add(i);
                }
            }
        }

        int end1 = bfs(graph, 0);
        int end2 = bfs(graph, end1);

        System.out.println(end1 + " " + end2);

        HashMap<Integer, Integer> dis = new HashMap<>();
        dfs(graph, end1, -1, 0, dis);
        dfs(graph, end2, -1, 0, dis);

        return new ArrayList<>(dis.values());
    }
    int bfs(ArrayList<ArrayList<Integer>> graph, int start)
    {
        int end = start;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> vis = new HashSet<>();
        vis.add(start);
        q.add(start);

        while(!q.isEmpty())
        {
            int size = q.size();
            while(size -- > 0)
            {
                end = q.poll();
                for(int v: graph.get(end))
                {
                    if(vis.add(v))
                        q.add(v);
                }
            }
        }
        return end;
    }
    void dfs(ArrayList<ArrayList<Integer>> graph, int start, int p, int currDis, HashMap<Integer, Integer> dis)
    {
        if(!dis.containsKey(start))
            dis.put(start, currDis);
        else
        {
            if(dis.get(start) < currDis)
                dis.put(start, currDis);
        }
        for(int v: graph.get(start))
        {
            if(v != p)
                dfs(graph, v, start, currDis + 1, dis);
        }
    }
    public static void main(String[] args)
    {
        ArrayList<Integer> ans = new FarthestNodeFromEachNode().farthestNodeFromEachNode(new int[]{1,1,1,1,1,0,0,0,0,0,1,0,0,0,0});
        System.out.println(ans);
        System.out.println();

        ans = new FarthestNodeFromEachNode().farthestNodeFromEachNode(new int[]{1,1,1,0,0,1,1,0,0,0,0,1,1,0,0});
        System.out.println(ans);
        System.out.println();

        ans = new FarthestNodeFromEachNode().farthestNodeFromEachNode(new int[]{0,0,0,0,0,0,0});
        System.out.println(ans);
        System.out.println();

        ans = new FarthestNodeFromEachNode().farthestNodeFromEachNode(new int[]{1,1,1,1,1,0,0});
        System.out.println(ans);
        System.out.println();
    }
}
