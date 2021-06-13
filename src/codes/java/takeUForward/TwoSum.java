package codes.java.takeUForward;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(target - arr[i]))
                return new int[]{i, map.get(target - arr[i])};
            else
                map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }
}
