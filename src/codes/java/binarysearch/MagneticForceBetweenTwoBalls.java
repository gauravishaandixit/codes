package codes.java.binarysearch;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length - 1] - position[0];

        int ans = -1;

        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(isPossibleWithMid(position, m, mid))
            {
                ans = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return ans;
    }

    boolean isPossibleWithMid(int[] position, int noOfBalls, int currMinDistance)
    {
        int noOfBallsPlaced = 1;
        int positionOfLastBall = 0;

        for(int i = 1; i < position.length; i++)
        {
            if(position[i] - position[positionOfLastBall] >= currMinDistance)
            {
                noOfBallsPlaced++;
                positionOfLastBall = i;
            }

            if(noOfBallsPlaced == noOfBalls)
                return true;
        }
        return false;
    }
}
