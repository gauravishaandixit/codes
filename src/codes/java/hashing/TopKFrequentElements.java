package codes.java.hashing;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    int[] topKFrequent(int[] nums, int K)
    {
        int[] ans = new int[K];

        Map<Integer, Integer> freq = new HashMap<>();
        for(int num: nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for(Map.Entry<Integer, Integer> me: freq.entrySet())
        {
            minHeap.add(me);
            if(minHeap.size() > K)
                minHeap.poll();
        }

        for(int i = 0; !minHeap.isEmpty(); i++)
            ans[i] = minHeap.poll().getKey();

        return ans;
    }
}
