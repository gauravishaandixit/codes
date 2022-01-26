package codes.java.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AmazonKNearestRestaurants {

    List<List<Integer>> findRes(List<List<Integer>> allLocations, int numRestaurants) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<List<Integer>> heap = new PriorityQueue<>((left, right) -> getDistance(right) - getDistance(left));

        for (List<Integer> location: allLocations) {
            heap.add(location);
            if (heap.size() > numRestaurants)
                heap.poll();
        }

        while (numRestaurants-- > 0)
            ans.add(heap.poll());

        return ans;
    }

    private int getDistance(List<Integer> point) {
        return point.get(0) * point.get(0) + point.get(1) * point.get(1);
    }

}
