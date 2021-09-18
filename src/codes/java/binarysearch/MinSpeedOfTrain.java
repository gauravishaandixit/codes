package codes.java.binarysearch;

import java.util.Arrays;

public class MinSpeedOfTrain {
    int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int high = 10000000;
        int ans = -1;

        while(low <= high) {
            int mid = (high - low) / 2 + low;
            if(isPossible(dist, mid, hour)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    boolean isPossible(int[] dist, int currSpeed, double hour) {
        double currTime = 0f;
        int i = 0;
        for(i = 0; i < dist.length - 1; i++) {
            currTime += (Math.ceil(Float.parseFloat(String.format("%.2f", (dist[i] * 1.0) / currSpeed))));
        }
        currTime += ((dist[i] * 1.0) / currSpeed);
        return currTime <= hour;
    }
}
