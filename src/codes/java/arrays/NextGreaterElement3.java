package codes.java.arrays;

// https://leetcode.com/problems/next-greater-element-iii/

public class NextGreaterElement3 {

    int nextGreaterElement3(int n)
    {
        char[] nums = (n + "").toCharArray();
        int i = nums.length - 2, j = nums.length - 1;

        while(i >= 0 && nums[i] >= nums[i+1])
            i--;

        if(i < 0)
            return -1;

        while (nums[j] <= nums[i])
            j--;

        swap(nums, i, j);
        reverse(nums, i + 1, nums.length);

        try{
            return Integer.parseInt(String.valueOf(nums));
        }
        catch (Exception e) {
            return -1;
        }
    }

    void swap(char[] arr, int i, int j)
    {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void reverse(char[] arr, int l, int r)
    {
        while(l <= r)
            swap(arr, l++, r--);
    }

}
