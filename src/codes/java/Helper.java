package codes.java;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Helper {

    class Node
    {
        int val;
        int count;
        Node(int val, int count)
        {
            this.val = val;
            this.count = count;
        }
    }


    void helper()
    {
        HashMap<String, PriorityQueue<Node>> map = new HashMap<>();

        map.computeIfAbsent("ABC", k-> new PriorityQueue<>(Comparator.comparingInt(a -> a.count))).add(new Node(4,5));
    }
    public static void main(String[] ar)
    {
    }
}
