package codes.java.dp.lis;

import java.util.Arrays;

public class LCIS {

    int lcis(int[] nums1, int[] nums2)
    {
        int m = nums1.length, n = nums2.length;
        int ans = 0;
        int[] T = new int[n];

        for(int i = 0; i < m; i++)
        {
            int curr = 0;
            for(int j = 0; j < n; j++)
            {
                if(nums1[i] == nums2[j])
                    T[j] = Math.max(T[j], curr + 1);

                if(nums1[i] > nums2[j])
                    curr = Math.max(curr, T[j]);
            }
        }

        for(int i = 0; i < n; i++)
            ans = Math.max(ans, T[i]);
        return ans;
    }

    public static void main(String[] ar)
    {
        System.out.println(new LCIS().lcis(new int[]{3, 4, 9, 1}, new int[]{5, 3, 8, 9, 10, 2, 1}));
    }
}
