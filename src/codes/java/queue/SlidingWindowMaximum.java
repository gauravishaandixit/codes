package codes.java.queue;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    int[] slidingWindowMaximum(int arr[], int k)
    {
        int ans[] = new int[arr.length - k + 1];
        int index = 0;
        Deque<Integer> dq = new LinkedList<>();
        for(int i = 0; i < k; i++)
        {
            while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i])
                dq.removeLast();
            dq.addLast(i);
        }
        for(int i = k; i < arr.length; i++)
        {
            ans[index++] = arr[dq.peekFirst()];

            while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i])
                dq.removeLast();

            while(!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.removeFirst();

            dq.addLast(i);
        }
        ans[index++] = arr[dq.peekFirst()];
        return ans;
    }
    void printArray(int nums[])
    {
        for(int num: nums)
            System.out.print(num + " ");

        System.out.print("\n");
    }
    public static void main(String[] args)
    {
        int ans[] = new SlidingWindowMaximum().slidingWindowMaximum(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        new SlidingWindowMaximum().printArray(ans);
    }
}
