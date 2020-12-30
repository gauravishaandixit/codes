package codes.java.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms_2 {
    int meetingRoom(int[][] times)
    {
        Arrays.sort(times, Comparator.comparingInt(a -> a[0]));
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.add(times[0]);
        for(int i = 1; i < times.length; i++)
        {
            if(!minHeap.isEmpty() && minHeap.peek()[1] <= times[i][0])
                minHeap.poll();

            minHeap.add(times[i]);
        }

        return minHeap.size();
    }

    public static void main(String[] a)
    {
        int[][] times = new int[][]{{0, 5}, {1, 2}, {1, 10}};
        System.out.println(new MeetingRooms_2().meetingRoom(times));

        times = new int[][] {{0, 5}, {1, 2}, {6, 10}};
        System.out.println(new MeetingRooms_2().meetingRoom(times));
    }
}
