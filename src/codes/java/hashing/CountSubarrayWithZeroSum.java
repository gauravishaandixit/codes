package codes.java.hashing;

import java.util.HashMap;

public class CountSubarrayWithZeroSum {
    int countSubarraysWithZeroSum(int[] nums)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int currSum = 0;
        for(int num: nums)
        {
            currSum += num;
            map.putIfAbsent(currSum, 0);
            count += map.get(currSum);
            map.put(currSum, map.get(currSum) + 1);
        }
        return count;
    }

    public static void main(String[] ar)
    {
        System.out.println(new CountSubarrayWithZeroSum().countSubarraysWithZeroSum(new int[]{0, 0, 5, 5, 0, 0}));
        System.out.println(new CountSubarrayWithZeroSum().countSubarraysWithZeroSum(new int[]{6, -1, -3, 4, -2, 2, 4, 6, -12, -7}));
    }
}
