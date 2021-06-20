package codes.java.takeUForward;

import java.util.Arrays;
import java.util.Comparator;

public class NMeetingsInOneRoom {
    int meetingsInOneRoom(int[][] meetings) {
        int ans = 1;

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[1]));

        int prevFinish = meetings[0][1];
        for(int i = 1; i < meetings.length; i++) {
            if(prevFinish < meetings[i][0]) {
                ans++;
                prevFinish = meetings[i][1];
            }
        }

        return ans;
    }
}
