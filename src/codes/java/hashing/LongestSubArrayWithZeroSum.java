package codes.java.hashing;
// Morgan

import java.util.HashMap;

public class LongestSubArrayWithZeroSum {

    int[] longestSubarray(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = -1;
        int maxLen = 0;

        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] == 0 ? -1 : 1;
            if (sum == 0) {
                start = 0;
                maxLen = i + 1;
            } else {
                if (map.containsKey(sum)) {
                    int currLen = i - map.get(sum);
                    if (currLen > maxLen) {
                        start = map.get(sum) + 1;
                        maxLen = i - map.get(sum);
                    }
                } else
                    map.put(sum, i);
            }
        }
        return new int[]{start, start + maxLen - 1};
    }

    public static void main(String[] args) {
        int[] ans = new LongestSubArrayWithZeroSum().longestSubarray(new int[]{1, 1, 0, 1, 1, 0, 1, 0});
        System.out.println(ans[0] + " " + ans[1]);
    }
}
