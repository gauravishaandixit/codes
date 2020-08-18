package codes.java.binarysearch;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        if(nums1.length > nums2.length)
            findMedianSortedArrays(nums2, nums1);

        int x = nums1.length; // smaller
        int y = nums2.length; // larger

        if(x == 0)
            return returnMedian(nums2);

        if(y == 0)
            return returnMedian(nums1);

        int low = 0;
        int high = x;
        //int len = (x+y+1)/2;
        double ans = 0.0;

        while(low <= high)
        {
            int len = (x+y+1)/2;
            int parX = (low + high)/2;

            if(parX > len)
                parX = len;

            int parY = len - parX;

            if(parY > nums2.length)
            {
                parY = nums2.length;
                parX = len - parY;
            }
            int maxLeftX = (parX == 0) ? Integer.MIN_VALUE : nums1[parX - 1];
            int minRightX = (parX == x) ? Integer.MAX_VALUE : nums1[parX];

            int maxLeftY = (parY == 0) ? Integer.MIN_VALUE : nums2[parY - 1];
            int minRightY = (parY == y) ? Integer.MAX_VALUE : nums2[parY];


            if(maxLeftX <= minRightY && maxLeftY <= minRightX)
            {
                if((x+y)%2 == 0)
                {
                    ans =  (double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                    break;
                }
                else
                {
                    ans = (double)Math.max(maxLeftX, maxLeftY);
                    break;
                }
            }
            else
            {
                if(maxLeftX > minRightY)
                    high = parX - 1;
                else
                    low = parX + 1;
            }

        }
        return ans;
    }

    double returnMedian(int[] nums)
    {
        int n = nums.length;
        if(n % 2 == 1)
            return (double)nums[n/2] ;
        else
            return (double)(nums[n/2-1] + nums[n/2])/2;
    }
}
