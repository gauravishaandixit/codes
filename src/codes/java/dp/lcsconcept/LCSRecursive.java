package codes.java.dp.lcsconcept;

public class LCSRecursive {
    int lcsRecursive(String s1, String s2, int m, int n)
    {
        if(m == 0 || n == 0)
            return 0;

        if(s1.charAt(m-1) == s2.charAt(n-1))
            return 1 + lcsRecursive(s1, s2, m - 1, n - 1);

        else
            return Math.max(lcsRecursive(s1, s2, m, n - 1),lcsRecursive(s1, s2, m - 1, n));
    }


    public static void main(String[] args)
    {
        String s1 = "abcgdef";
        int m = s1.length();
        String s2 = "afbgcfef";
        int n = s2.length();
        System.out.println(new LCSRecursive().lcsRecursive(s1, s2, m, n));
    }
}
