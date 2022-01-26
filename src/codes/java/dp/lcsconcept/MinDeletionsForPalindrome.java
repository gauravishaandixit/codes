package codes.java.dp.lcsconcept;

//Min no of deletion to make a string palindrome
// s.length - lps(s)
public class MinDeletionsForPalindrome {

    int minDeletions(String s) {
        if (s.length() == 0)
            return 0;
        int n = s.length();
        int[][] T = new int[n][n];

        for (int i = 0; i < n; i++)
            T[i][i] = 1;

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (l == 2)
                        T[i][j] = 2;
                    else
                        T[i][j] = 2 + T[i + 1][j - 1];
                } else
                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
            }
        }

        return n - T[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new MinDeletionsForPalindrome().minDeletions("abdhbcegbmna"));
        System.out.println(new MinDeletionsForPalindrome().minDeletions("abcd"));
        System.out.println(new MinDeletionsForPalindrome().minDeletions("abcdedcba"));
        System.out.println(new MinDeletionsForPalindrome().minDeletions(""));
    }
}