package codes.java.hashing;

import java.util.*;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> freq = new HashMap<>();
        for(String word: words)
            freq.put(word, freq.getOrDefault(word, 0) + 1);

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());

        for(Map.Entry<String, Integer> me: freq.entrySet())
        {
            minHeap.add(me);
            if(minHeap.size() > k)
                minHeap.poll();
        }
        while(ans.size() != k)
            ans.add(0, minHeap.poll().getKey());

        return ans;
    }

}
