package codes.java.dp.others;

import java.util.List;

public class MaxValueOfKCoinsFromPiles {

    public int maxValueOfCoinsRecursive(List<List<Integer>> piles, int k) {
        return dp(0, k, piles);
    }

    int dp(int index, int k, List<List<Integer>> piles) {
        if(index == piles.size() || k == 0) {
            return 0;
        }

        int best = dp(index + 1, k, piles); // not picking anything from current pile
        int currValue = 0;

        for(int i = 0; i < Math.min(k, piles.get(index).size()); i++) {
            currValue += piles.get(index).get(i);
            best = Math.max(best, currValue + dp(index + 1, k - (i + 1), piles));
        }

        return best;
    }

    public int maxValueOfCoinsMemo(List<List<Integer>> piles, int k) {
        int[][] memo = new int[piles.size()][k + 1];
        return dp(0, k, piles, memo);
    }

    int dp(int index, int k, List<List<Integer>> piles, int[][] memo) {
        if(index == piles.size() || k == 0) {
            return 0;
        }

        if(memo[index][k] != 0)
            return memo[index][k];

        int best = dp(index + 1, k, piles, memo); // not picking anything from current pile
        int currValue = 0;

        for(int i = 0; i < Math.min(k, piles.get(index).size()); i++) {
            currValue += piles.get(index).get(i);
            best = Math.max(best, currValue + dp(index + 1, k - (i + 1), piles, memo));
        }

        return memo[index][k] = best;
    }

}
