package codes.java.binarysearch;

import java.util.Arrays;


// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

public class Bouquets {

    int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k)
            return -1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i : bloomDay) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        while (min <= max) {
            int mid = min + (max - min) / 2;
            int possibleBookies = getPossibleBookies(bloomDay, mid, k);
            if (possibleBookies < m) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return min;
    }

    private int getPossibleBookies(int[] bloomDay, int day, int k) {
        int bouquets = 0, flowersCollected = 0;
        for (int value : bloomDay) {
            if (value <= day) {
                flowersCollected++;
            } else {
                flowersCollected = 0;
            }
            if (flowersCollected == k) {
                bouquets++;
                flowersCollected = 0;
            }
        }
        return bouquets;
    }
}
