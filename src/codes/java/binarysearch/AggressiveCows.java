package codes.java.binarysearch;

//Farmer John has built a new long barn, with N stalls.
//Given an array of integers A of size N where each element of the array represents the location of the stall,
//and an integer B which represent the number of cows.
//
//His cows don’t like this barn layout and become aggressive towards each other once put
//into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls,
//such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?

import java.util.ArrayList;
import java.util.Collections;

public class AggressiveCows {
    int largestMinDistance(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int n = A.size();
        int low = 0;
        int high = A.get(n - 1) - A.get(0);

        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(A, B, mid)) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return ans;
    }

    boolean isPossible(ArrayList<Integer> arr, int cows, int maxDistance) {
        int numCows = 1;
        int prevCowPos = 0;

        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) - arr.get(prevCowPos) >= maxDistance) {
                numCows++;
                prevCowPos = i;
            }
            if (numCows == cows)
                return true;
        }
        return false;
    }
}
