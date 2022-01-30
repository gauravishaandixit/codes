package codes.java.hashing;

import java.util.HashMap;

public class LongestSubarrayWithSumK {

    int lengthOfSubarray(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (currSum == k) {
                ans = i + 1;
            }

            if (!map.containsKey(currSum))
                map.put(currSum, i);

            if (map.containsKey(currSum - k)) {
                if (ans < i - map.get(currSum - k))
                    ans = i - map.get(currSum - k);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubarrayWithSumK().lengthOfSubarray(new int[]{10, 5, 2, 7, 1, 9}, 15));
        System.out.println(new LongestSubarrayWithSumK().lengthOfSubarray(new int[]{-5, 8, -14, 2, 4, 12}, -5));
        System.out.println(new LongestSubarrayWithSumK().lengthOfSubarray(new int[]{-1, 2, 3}, 6));
    }
}
