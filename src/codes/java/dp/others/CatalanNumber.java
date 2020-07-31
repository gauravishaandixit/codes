package codes.java.dp.others;

public class CatalanNumber {

    int nthCatalan(int n) {
        long mod = 1000000007;
        long[] catalan= new long[n+1];
        catalan[0] = 1;
        catalan[1] = 1;

        for(int i = 2; i <= n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                catalan[i] = (catalan[i] + (catalan[j] * catalan[i-j-1]) % mod) % mod;
            }
        }
        return (int)catalan[n];
    }

}
