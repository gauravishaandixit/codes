package codes.java.dp.string;

//Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
//
//'?' Matches any single character.
//'*' Matches any sequence of characters (including the empty sequence).

//https://leetcode.com/problems/wildcard-matching/
public class WildcardMatching {

    boolean wildcardMatching(String s, String p)
    {
        int m = s.length(), n = p.length();
        boolean T[][] = new boolean[m + 1][n + 1];
        T[0][0] = true;

        for(int i = 1; i <= n; i++)
        {
            if(p.charAt(i - 1) == '*')
                T[0][i] = true;
            else
                break;
        }

        for(int i = 1; i <= m; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    T[i][j] = T[i - 1][j - 1];
                else
                    if(p.charAt(j - 1) == '*')
                        T[i][j] = T[i][j - 1] || T[i - 1][j];
            }
        }
        return T[m][n];
    }
    public static void main(String[] a)
    {
        System.out.println(new WildcardMatching().wildcardMatching("aa","a"));
        System.out.println(new WildcardMatching().wildcardMatching("aa","*"));
        System.out.println(new WildcardMatching().wildcardMatching("cb","?a"));
        System.out.println(new WildcardMatching().wildcardMatching("adceb","a*b"));
        System.out.println(new WildcardMatching().wildcardMatching("acdcb","a*c?b"));

    }
}
