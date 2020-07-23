package codes.java.dp.lcsconcept;

public class PrintSCS {
    String printSCS(String s1, String s2)
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
        System.out.print("Length Of SCS:: " + (m + n - T[m][n]));
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
                {
                    sb.insert(0, s2.charAt(j - 1));
                    j--;
                }
                else
                {
                    sb.insert(0, s1.charAt(i - 1));
                    i--;
                }
            }
        }

        while(i > 0)
        {
            sb.insert(0, s1.charAt(i - 1));
            i--;
        }

        while(j > 0)
        {
            sb.insert(0, s2.charAt(j - 1));
            j--;
        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(", SCS:: " + new PrintSCS().printSCS("ABCDEF","AYBZEDF"));
        System.out.println(", SCS:: " + new PrintSCS().printSCS("geek","eke"));
        System.out.println(", SCS:: " + new PrintSCS().printSCS("ABC","DEF"));
        System.out.println(", SCS:: " + new PrintSCS().printSCS("ABCDEFGH","DEF"));
    }
}
