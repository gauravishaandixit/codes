package codes.java.dp.string;

public class InterleavingStrings {

    boolean interleavingString(String s1, String s2, String s3)
    {
        int m = s1.length(), n = s2.length();
        if(m + n != s3.length())
            return false;

        boolean T[][] = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
        {
            for(int j = 0; j <= n; j++)
            {
                if(i == 0 && j == 0)
                    T[i][j] = true;
                else
                {
                    if(i == 0)
                        T[i][j] = T[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1));
                    else
                    {
                        if(j == 0)
                            T[i][j] = T[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1));
                        else
                            T[i][j] = T[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1)) || T[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1));
                    }
                }
            }
        }
        return T[m][n];
    }

    public static void main(String[] args)
    {
        System.out.println(new InterleavingStrings().interleavingString("aabcc", "dbbca","aadbbcbcac"));
        System.out.println(new InterleavingStrings().interleavingString("aabcc", "dbbca","aadbbbaccc"));
    }
}
