package codes.java.binarysearch;

import java.util.Arrays;

//Calculate and return minimum time required to paint all boards under the constraints
// that any painter will only paint contiguous sections of board.
public class PaintersAlgorithm {
    int minTime(int[] lengths, int painters) {
        int low = Arrays.stream(lengths).max().getAsInt();
        int high = Arrays.stream(lengths).sum();
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(lengths, mid, painters)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    boolean isPossible(int[] lengths, int maxTime, int painters) {
        int numOfPainters = 1;
        int currTime = 0;

        for (int length : lengths) {
            currTime += length;
            if (currTime > maxTime) {
                numOfPainters++;
                currTime = length;
            }
            if (numOfPainters > painters)
                return false;
        }
        return true;
    }
}
