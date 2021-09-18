package codes.java.binarysearch;


import java.util.Arrays;

// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/
public class MinPenalty {

    int minimumSize(int[] bags, int maxOperations) {
        int ans = -1;

        int low = 1;
        int high = Arrays.stream(bags).max().getAsInt();

        while(low <= high) {
            int mid = (high - low) / 2 + low;
            if(isPossible(bags, mid, maxOperations)) {
                ans = mid;
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean isPossible(int[] bags, int mid, int maxOperations) {
        int cuts = 0;
        for(int balls: bags) {
            cuts += ((balls - 1) / mid);
        }
        return cuts <= maxOperations;
    }

    public static void main(String[] args) {
        System.out.println(new MinPenalty().minimumSize(new int[]{9}, 2));
        System.out.println(new MinPenalty().minimumSize(new int[]{2,4,8,2}, 4));
        System.out.println(new MinPenalty().minimumSize(new int[]{7, 17}, 2));
    }

}
