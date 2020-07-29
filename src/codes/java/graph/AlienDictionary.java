package codes.java.graph;

import java.util.ArrayList;
import java.util.Stack;

public class AlienDictionary {
    char[] orderOfLetters(String[] dict, int k)
    {
        ArrayList<ArrayList<Character>> graph = new ArrayList<>();

        for(int i = 0; i < k; i++)
            graph.add(new ArrayList<>());

        int n = dict.length;

        for(int i = 0; i < n - 1; i++)
        {
            String w1 = dict[i];
            String w2 = dict[i + 1];

            int l = Math.min(w1.length(), w2.length());

            for(int j = 0; j < l; j++)
            {
                if(w1.charAt(j) != w2.charAt(j))
                {
                    graph.get(w1.charAt(j) - 'a').add(w2.charAt(j));
                    break;
                }
            }
        }
        System.out.println(graph);
        Stack<Character> order = new Stack<>();
        int[] vis = new int[k];

        for(int i = 0; i < k; i++)
        {
            if(vis[i] == 0)
                dfs(graph, (char)(i + 'a'), vis, order);
        }
        System.out.println(order);

        char[] ans = new char[k];
        int i = 0;
        while(!order.isEmpty())
            ans[i++] = order.pop();

        return ans;
    }

    void dfs(ArrayList<ArrayList<Character>> graph, char s, int[] vis, Stack<Character> order)
    {
        vis[s - 'a'] = 1;

        for(char neigh: graph.get(s - 'a'))
        {
            if(vis[neigh - 'a'] == 0)
                dfs(graph, neigh, vis, order);
        }
        order.push(s);
    }
    void printArray(char[] arr)
    {
        for(char ch: arr)
            System.out.print(ch + " ");

        System.out.println();
    }
    public static void main(String[] args)
    {
        String[] dict = new String[]{"baa", "baa", "abca", "cab", "cad"};
        int k = 4;
        char[] ans = new AlienDictionary().orderOfLetters(dict, k);
        new AlienDictionary().printArray(ans);

        dict = new String[]{ "caa", "aaa", "aab" };
        k = 3;

        ans = new AlienDictionary().orderOfLetters(dict, k);
        new AlienDictionary().printArray(ans);
    }
}
