package codes.java.dp.lcsconcept;

public class PrintLCS {
    String printLCS(String s1, String s2)
    {
        int m = s1.length(), n = s2.length();
        int T[][] = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    T[i][j] = 1 + T[i - 1][j - 1];
                else
                    T[i][j] = Math.max(T[i - 1][j], T[i][j - 1]);
            }
        }
        System.out.print("Length Of LCS:: " + T[m][n]);
        StringBuffer sb = new StringBuffer("");
        int i = m, j = n;

        while(i > 0 && j > 0)
        {
            if(s1.charAt(i - 1) == s2.charAt(j - 1))
            {
                sb.insert(0, s1.charAt(i - 1));
                i--;
                j--;
            }
            else
            {
                if(T[i - 1][j] < T[i][j - 1])
                    j--;
                else
                    i--;
            }
        }

        return sb.toString();
    }
    public static void main(String[] args)
    {
        System.out.println(", LCS:: " + new PrintLCS().printLCS("abcgdef","afbgcfef"));
    }
}
