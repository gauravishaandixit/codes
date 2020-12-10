package codes.java.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/sort-array-by-increasing-frequency/

public class FrequencySorting_1 {

    int[] freqSorting(int[] nums)
    {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num: nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b)->freq.get(a) == freq.get(b) ? b.compareTo(a) : freq.get(a).compareTo(freq.get(b)));
        for(int num: nums)
            minHeap.add(num);


        int index = 0;
        while(!minHeap.isEmpty())
            nums[index++] = minHeap.poll();

        return nums;
    }
}
