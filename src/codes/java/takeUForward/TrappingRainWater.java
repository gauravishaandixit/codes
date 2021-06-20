package codes.java.takeUForward;

public class TrappingRainWater {
    
    int trap(int[] height) {
        int ans = 0;

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        while(left <= right) {
            if(height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                ans += leftMax - height[left];
                left++;
            }
            else {
                rightMax = Math.max(rightMax, height[right]);
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
