package codes.java.dp.string;

public class RegularExpressionMatching {
    boolean isMatch(String s, String p) {

        boolean matches[][] = new boolean[s.length() + 1][p.length() + 1];

        matches[0][0] = true;

        //a*b*c*
        for(int i = 1; i <= p.length(); i++)
            if(p.charAt(i-1) == '*')
                matches[0][i] = matches[0][i-2];

        for(int i = 1; i <= s.length(); i++)
        {
            for(int j = 1; j <= p.length(); j++)
            {
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j-1) == '.')
                    matches[i][j] = matches[i-1][j-1];
                else
                {
                    if(p.charAt(j-1) == '*' && j > 1)
                    {
                        matches[i][j] = matches[i][j-2];
                        if(p.charAt(j-2) == '.' || s.charAt(i-1) == p.charAt(j-2))
                            matches[i][j] |= matches[i-1][j];
                    }
                    else
                        matches[i][j] = false;
                }
            }
        }
        return matches[s.length()][p.length()];
    }
}
