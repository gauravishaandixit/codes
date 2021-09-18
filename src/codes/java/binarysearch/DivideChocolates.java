package codes.java.binarysearch;
//Given an array chocolate of n non-negative integers, where the values are sweetness levels of the chocolate.
// You are also given a value k which denotes the number of friends you will share this chocolate with.
// Your friends are greedy, so they will always take the highest sweetness chunk.
// Find out what is the maximum sweetness level you could get.

import java.util.Arrays;

// Split the array into k + 1 non-empty continuous sub-arrays.
// Write an algorithm to isPossible the minimum sum among these k + 1 sub-arrays.
public class DivideChocolates {
    int divideChocolates(int[] chocolates, int k) {
        int low = Arrays.stream(chocolates).min().getAsInt();
        int high = Arrays.stream(chocolates).sum();
        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isPossible(chocolates, k, mid)) {
                ans = mid;
                low = mid + 1;
            }
            else
                high = mid - 1;
        }
        return ans;
    }

    boolean isPossible(int[] chocolates, int k, int minSum) {
        int noOfFriends = 0;
        int currSum = 0;

        for(int chocolate: chocolates) {
            currSum += chocolate;
            if(currSum >= minSum) {
                noOfFriends++;
                currSum = 0;
            }
        }
        return noOfFriends >= k + 1;
    }

    public static void main(String[] args) {
        int[] chocolates = new int[]{6, 3, 2, 8, 7, 5};
        int k = 3;
        System.out.println(new DivideChocolates().divideChocolates(chocolates, k));

        chocolates= new int[]{1,2,3,4,5,6,7,8, 9};
        k = 5;
        System.out.println(new DivideChocolates().divideChocolates(chocolates, k));

        chocolates= new int[]{5,6,7, 8, 9, 1, 2, 3, 4};
        k = 8;
        System.out.println(new DivideChocolates().divideChocolates(chocolates, k));

        chocolates= new int[]{1,2,2,1,2,2,1,2,2};
        k = 2;
        System.out.println(new DivideChocolates().divideChocolates(chocolates, k));
    }
}
