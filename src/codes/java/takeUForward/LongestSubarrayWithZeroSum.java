package codes.java.takeUForward;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithZeroSum {
    int longestSubarrayWithZeroSum(int[] arr) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum == 0)
                max = i + 1;

            if(map.containsKey(sum))
                max = Math.max(max, i - map.get(sum));
            else
                map.put(sum , i);
        }
        return max;
    }
}
