package codes.java.arrays;

public class JumpGame2 {
    int jump(int[] nums)
    {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for(int i = 0; i < nums.length - 1; i++)
        {
            if(i > curFarthest)
                return -1;

            curFarthest = Math.max(curFarthest, i + nums[i]);

            if(i == curEnd)
            {
                jumps++;
                curEnd = curFarthest;
            }

            if(curEnd > nums.length - 1)
                break;
        }
        return jumps;
    }
}
