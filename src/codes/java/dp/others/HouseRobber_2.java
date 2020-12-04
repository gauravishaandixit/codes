package codes.java.dp.others;

public class HouseRobber_2 {

    int houseRobber(int[] nums)
    {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int[] T = new int[n];

        T[0] = nums[0];
        T[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++)
            T[i] = Math.max(T[i - 1], T[i - 2] + nums[i]);

        int ans = T[n - 2];

        T[1] = nums[1];
        T[2] = Math.max(nums[1], nums[2]);
        for(int i = 3; i < n; i++)
            T[i] = Math.max(T[i - 1], T[i - 2] + nums[i]);


        return Math.max(ans, T[n - 1]);
    }

}
