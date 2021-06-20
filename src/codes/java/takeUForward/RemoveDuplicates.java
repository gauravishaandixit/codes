package codes.java.takeUForward;

public class RemoveDuplicates {
    int removeDuplicates(int[] nums) {
        int i = 0;
        for(int num: nums) {
            if(i == 0 || num != nums[i - 1])
                nums[i++] = num;
        }
        return i;
    }
    int removeDuplicates(int[] nums, int n) {
        int i = 0, j = 1;
        while(j < n) {
            if(nums[i] != nums[j])
                nums[++i] = nums[j];
            j++;
        }
        return i + 1;
    }
}
