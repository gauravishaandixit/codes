package codes.java.dp.lcsconcept;

public class LCSubstring {

    int longestCommonSubstring(String s1, String s2)
    {
        int m = s1.length();
        int n = s2.length();
        int T[][] = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    T[i][j] = 1 + T[i - 1][j - 1];
                else
                    T[i][j] = 0;
            }
        }
        return T[m][n];
    }

    public static void main(String[] args)
    {
        System.out.println(new LCSubstring().longestCommonSubstring("abcgdef","abgcfef"));
    }
}
