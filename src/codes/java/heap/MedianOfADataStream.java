package codes.java.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfADataStream {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    MedianOfADataStream()
    {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    void add(int num)
    {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if(minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());
    }

    double getMedian()
    {
        if(minHeap.size() == maxHeap.size())
            return (minHeap.peek() + maxHeap.peek()) / 2.0;

        return maxHeap.peek();
    }

    public static void main(String[] ar)
    {
        MedianOfADataStream obj = new MedianOfADataStream();
        obj.add(1);
        System.out.println(obj.getMedian());

        obj.add(16);
        System.out.println(obj.getMedian());

        obj.add(87);
        System.out.println(obj.getMedian());

        obj.add(68);
        System.out.println(obj.getMedian());

    }
}
