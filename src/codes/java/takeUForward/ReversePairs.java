package codes.java.takeUForward;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    int mergeSort(int[] nums, int low, int high) {
        if(low >= high)
            return 0;
        int mid = low + (high - low) / 2;
        int reversePairs = mergeSort(nums, low, mid);
        reversePairs += mergeSort(nums, mid + 1, high);

        reversePairs += merge(nums, low, mid, high);

        return reversePairs;
    }

    int merge(int[] nums, int low, int mid, int high) {
        int i = low, j = mid + 1;
        int[] temp = new int[nums.length];
        int countReversePairs = 0;
        for(; i <= mid; i++) {
            while(j <= high && nums[i] > 2L * nums[j])
                j++;

            countReversePairs += (j - (mid + 1));
        }

        i = low;
        j = mid + 1;
        int k = low;
        while(i <= mid && j <= high) {
            if(nums[i] <= nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }

        while(i <= mid)
            temp[k++] = nums[i++];

        while(j <= high)
            temp[k++] = nums[j++];


        for(i = low; i <= high; i++)
            nums[i] = temp[i];

        return countReversePairs;
    }
}
