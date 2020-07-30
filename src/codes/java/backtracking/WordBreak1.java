package codes.java.backtracking;

//https://leetcode.com/problems/word-break/

import java.util.HashSet;
import java.util.List;

public class WordBreak1 {
    boolean wordBreak(String s, List<String> wordDict)
    {

        boolean[] dp = new boolean[s.length() + 1];
        HashSet<String> set = new HashSet<>(wordDict);

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++)
        {
            for (int j = i - 1; j >= 0; j--)
            {
                dp[i] = dp[j] && set.contains(s.substring(j, i));
                if(dp[i]) break;
            }
        }
        return dp[s.length()];
    }
}
