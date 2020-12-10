package codes.java.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/sort-characters-by-frequency/
public class FrequencySorting_2 {

    String sortFrequency(String s)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty())
        {
            Map.Entry<Character, Integer> e = pq.poll();
            for (int i = 0; i < (int)e.getValue(); i++)
                sb.append(e.getKey());
        }
        return sb.toString();
    }


    public static void main(String[] ar)
    {
        System.out.println(new FrequencySorting_2().sortFrequency("acacac"));
        System.out.println(new FrequencySorting_2().sortFrequency("tree"));
    }

}
