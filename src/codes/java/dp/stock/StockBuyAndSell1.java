package codes.java.dp.stock;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class StockBuyAndSell1 {

    public int maxProfit(int[] p) {
        if(p.length==0 || p.length==1)
            return 0;

        int maxp=0, min_buy=p[0];
        for(int i=1;i<p.length;i++)
        {
            maxp=Math.max(maxp, p[i]-min_buy);
            min_buy=Math.min(min_buy,p[i]);
        }
        return maxp;
    }
}
