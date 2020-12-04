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


/*
* In addition to the above, I would like to tell you that there are none covid positive cases within a 3 km radius from
* my home. So I can assure you that I have never come in contact with any covid infected person.
* Also, the Arogya Setu app is showing around 10 people who were covid positive in the last one month in 10 km of the
* area near me.

 *
*
* */