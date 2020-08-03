package codes.java.arrays;

import java.util.PriorityQueue;

public class SortNearlySortedArray {

    void nearlySortedArray(int[] arr, int K)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i = 0; i <= K; i++)
            minHeap.add(arr[i]);

        int index = 0;
        for(int i = K + 1; i < arr.length; i++)
        {
            arr[index++] = minHeap.poll();
            minHeap.add(arr[i]);
        }

        while(!minHeap.isEmpty())
            arr[index++] = minHeap.poll();
    }
}
