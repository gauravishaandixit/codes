package codes.java.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CloneGraph {

    class Node
    {
        int val;
        ArrayList<Node> neigh;
        Node(int val)
        {
            this.val = val;
            this.neigh = new ArrayList<>();
        }
    }

    Node cloneGraph(Node node)
    {
        if(node == null)
            return null;

        HashMap<Integer, Node> map = new HashMap<>();
        Node newNode = new Node(node.val);
        map.put(node.val, newNode);
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty())
        {
            Node curr = q.poll();
            for(Node v: curr.neigh)
            {
                if(!map.containsKey(v.val))
                {
                    map.put(v.val, new Node(v.val));
                    q.add(v);
                }
                map.get(curr.val).neigh.add(map.get(v.val));
            }
        }
        return newNode;
    }
}
