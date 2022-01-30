package codes.java.binarysearch;

import java.util.Arrays;

public class WoodCutter {
    int maxHeight(int[] heights, int wood) {
        int low = 0;
        int high = Arrays.stream(heights).max().getAsInt();
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossibleToCut(heights, mid, wood)) {
                ans = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return ans;
    }

    boolean isPossibleToCut(int[] heights, int currHeight, int wood) {
        int totalWood = 0;
        for (int height : heights)
            totalWood += height > currHeight ? height - currHeight : 0;

        return totalWood >= wood;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{20, 15, 10, 17};
        int requiredWood = 7;
        System.out.println(new WoodCutter().maxHeight(heights, requiredWood));

        heights = new int[]{4, 42, 40, 26, 46};
        requiredWood = 20;
        System.out.println(new WoodCutter().maxHeight(heights, requiredWood));
    }
}
