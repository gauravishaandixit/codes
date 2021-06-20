package codes.java.takeUForward;

public class MaxConsecutiveOnes {

    int maxConsecutiveOnes(int[] nums) {
        int ans = 0, count = 0;
        for(int num: nums) {
            if(num == 0)
                count = 0;
            else
                count++;

            ans = Math.max(ans, count);
        }
        return ans;
    }

}
