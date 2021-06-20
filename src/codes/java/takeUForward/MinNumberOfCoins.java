package codes.java.takeUForward;

//Greedy
//Greedy works when sum of two coins is less than third one in sorted order
public class MinNumberOfCoins {

    int minCoins(int[] coins, int V) {
        int n = coins.length;
        int ans = 0;
        for(int i = n - 1; i >= 0; i--) {
            while(V >= coins[i]) {
                V -= coins[i];
                ans++;
            }
        }
        return ans;
    }

}
