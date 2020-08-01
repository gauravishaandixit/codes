package codes.java.dp.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    boolean wordBreak(String word, List<String> dict)
    {
        Set<String> set = new HashSet<>(dict);
        boolean dp[] = new boolean[word.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= word.length(); i++)
        {
            for(int j = i - 1; j >= 0; j--)
            {
                String sub = word.substring(j,i);
                //System.out.print(sub + " ");
                dp[i] = dp[j] && set.contains(sub);
                if(dp[i])
                    break;
            }
            //System.out.println();
        }
        return dp[word.length()];
    }

    public static void main(String[] args)
    {
        System.out.println(new WordBreak().wordBreak("leetcode", Arrays.asList("leet", "code")));
    }
}
