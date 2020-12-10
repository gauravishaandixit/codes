package codes.java.hashing;

import java.util.PriorityQueue;

public class KClosetPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {


        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> getOriginDistance(b) - getOriginDistance(a));


        for(int[] point: points)
        {
            maxHeap.add(point);
            if(maxHeap.size() > K)
                maxHeap.poll();
        }

        int[][] ans = new int[2][K];
        for(int i = 0; !maxHeap.isEmpty(); i++)
            ans[i] = maxHeap.poll();


        return ans;
    }


    int getOriginDistance(int[] point)
    {
        return point[0] * point[0] + point[1] * point[1];
    }

}
