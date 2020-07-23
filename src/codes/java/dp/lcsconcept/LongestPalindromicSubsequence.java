package codes.java.dp.lcsconcept;


//LCS of S and reverse(S);
//This is second method
public class LongestPalindromicSubsequence {
    int lps(String s)
    {
        int n = s.length();
        int T[][] = new int[n][n];

        for(int i = 0; i < n; i++)
            T[i][i] = 1;

        for(int length = 1; length < n; length ++)
        {
            for(int i = 0; i < n - length; i++)
            {
                int j = i + length;

                if(s.charAt(i) == s.charAt(j))
                    T[i][j] = 2 + T[i + 1][j - 1];
                else
                    T[i][j] = Math.max(T[i + 1][j], T[i][j-1]);
            }
        }

        return T[0][n - 1];
    }

    public static void main(String args[])
    {
        System.out.println(new LongestPalindromicSubsequence().lps("abdhbcegbmna"));
        System.out.println(new LongestPalindromicSubsequence().lps("abcd"));
        System.out.println(new LongestPalindromicSubsequence().lps("abcdedcba"));
    }
}
