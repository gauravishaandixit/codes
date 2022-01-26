package codes.java.dp.lis;

// https://leetcode.com/problems/longest-continuous-increasing-subsequence/
// [1,3,5,4,7]
// Ans = 3, [1,3,5]

public class LongestContinuousIncSub {
    int lengthOfLCIS(int[] nums) {
        int res = 0, cur = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) cur = 1;
            else if (nums[i] > nums[i-1]) cur++;
            else {
                res = Math.max(res, cur);
                cur = 1;
            }

        }
        res = Math.max(res, cur);

        return res;
    }
}
