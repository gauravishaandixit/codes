package codes.java.takeUForward;

public class Stock1 {
    int maxProfit(int[] prices) {
        int ans = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int price : prices) {
            minPrice = Math.min(minPrice, price);
            ans = Math.max(ans, price - minPrice);
        }
        return ans;
    }
}
