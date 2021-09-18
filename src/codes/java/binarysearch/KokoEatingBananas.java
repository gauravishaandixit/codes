package codes.java.binarysearch;

import java.util.Arrays;

// https://leetcode.com/problems/koko-eating-bananas/

public class KokoEatingBananas {
    int minEatingSpeed(int[] piles, int H) {
        int min = 1;
        int max = Arrays.stream(piles).max().getAsInt();
        int ans = 0;

        while(min <= max){
            int mid = min + (max - min) / 2;
            if(isPossible(piles, mid, H)) {
                ans = mid;
                max = mid - 1;
            }
            else
                min = mid + 1;
        }
        return ans;
    }

    boolean isPossible(int[] nums, int maxBanana, int H) {
        int totalHours = 0;

        for(int banana : nums) {
            totalHours += (banana + maxBanana - 1)/ maxBanana;
        }
        return totalHours <= H;
    }
}
