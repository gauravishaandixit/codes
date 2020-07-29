package codes.java.dp.string;

//https://www.interviewbit.com/problems/distinct-subsequences/
//Given two sequences A, B, count number of unique ways in sequence A,
// to form a subsequence that is identical to the sequence B.

// A = "rabbbit"
// B = "rabbit"
// ways 3


/*


The first case is easy to catch. When the new character in s[i-1],
is not equal with the head char in t, t[j-1],
we can no longer increment the number of distinct subsequences,
it is the same as the situation before incrementing the s, so dp[i][j] = dp[i-1][j].

However, when the new incrementing character in s, s[i-1] is equal with t[j-1],
which contains two case:

We don't match those two characters, which means that
it still has original number of distinct subsequences, so dp[i][j] = dp[i-1][j].
We match those two characters, in this way. dp[i][j] = dp[i-1][j-1];
Thus, including both two case, dp[i][j] = dp[i-1][j] + dp[i-1][j-1]

*/
public class DistinctSubsequences {

    int numDistict(String s1, String s2)
    {
        int m = s1.length();
        int n = s2.length();

        int T[][] = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++)
            T[i][0] = 1;

        for(int j = 1; j <= n; j++)
            T[0][j] = 0;

        for(int i = 1; i <= m; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                T[i][j] = T[i - 1][j];
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    T[i][j] += T[i - 1][j - 1];
            }
        }
        return T[m][n];
    }

    public static void main(String[] args)
    {
        System.out.println(new DistinctSubsequences().numDistict("abc", "abc"));
        System.out.println(new DistinctSubsequences().numDistict("rabbbit", "rabbit"));
    }
}
