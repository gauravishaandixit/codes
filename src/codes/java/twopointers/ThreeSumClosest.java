package codes.java.twopointers;

import java.util.Arrays;

public class ThreeSumClosest {

    int threeSumClosest(int arr[], int target)
    {
        int ans = 0, n = arr.length;
        int diff =  Integer.MAX_VALUE;
        Arrays.sort(arr);

        for(int i = 0; i < n - 1; i++)
        {
            int j = i + 1, k = n - 1;
            while( j < k)
            {
                int sum = arr[i] + arr[j] + arr[k];
                if(sum == target )
                    return target;
                else
                {
                    if(sum > target)
                        k--;
                    else
                        j++;
                }
                if(Math.abs(target - sum) < diff)
                {
                    ans = sum;
                    diff = Math.abs(target - sum);
                }
            }
        }
        return ans;
    }
}
