package codes.java.hashing;

import java.util.HashMap;

public class SubarrayEqualNumberOfZeroesAndOnes {

    int countOfSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int currSum = 0;
        for (int num : nums) {
            currSum += (num == 0 ? -1 : 1);
            count += map.getOrDefault(currSum, 0);
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] ar) {
        System.out.println(new SubarrayEqualNumberOfZeroesAndOnes().countOfSubarray(new int[]{1, 0, 0, 1, 0, 1, 1}));
        System.out.println(new SubarrayEqualNumberOfZeroesAndOnes().countOfSubarray(new int[]{1, 1, 1, 1, 0}));
    }
}
