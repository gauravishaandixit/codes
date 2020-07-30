package codes.java.dp.string;

public class LongestPalindromicSubstring {

    String lpss1(String str)
    {
        char ch[] = str.toCharArray();
        int n = ch.length;
        int maxLen = 0;
        int start = 0, s = 0, e = 0;

        for(int i = 0; i < n; i++)
        {
            s = i - 1;
            e = i + 1;

            while(s >= 0 && e < n && ch[s] == ch[e])
            {
                s--;
                e++;
            }

            if(maxLen < e - s - 1) // not e - s + 1 but e - s + - 2 beacuse while loop ran one extra time and
                // then chars were not equal
            {
                maxLen = e - s - 1;
                start = s + 1;
            }
            s = i - 1;
            e = i;

            while(s >= 0 && e < n && ch[s] == ch[e])
            {
                s--;
                e++;
            }

            if(maxLen < e - s - 1) {
                maxLen = e - s - 1;
                start = s + 1;
            }
        }
        return str.substring(start, start + maxLen);
    }

    String lpss2(String s)
    {
        int n = s.length();
        boolean[][] T = new boolean[n][n];
        int maxLen = 0;
        int start = 0;
        for(int i = n - 1; i >= 0; i--)
        {
            for(int j = i; j < n; j++)
            {
                T[i][j]  = s.charAt(i) == s.charAt(j) && (j - i <= 2 || T[i + 1][j - 1]);

                if(T[i][j] && maxLen < (j - i + 1))
                {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }


    public static void main(String[] args)
    {
        System.out.println(new LongestPalindromicSubstring().lpss1("aaaabaa"));
        System.out.println(new LongestPalindromicSubstring().lpss1("efgabcba"));
        System.out.println(new LongestPalindromicSubstring().lpss1("mnopomn"));
        System.out.println(new LongestPalindromicSubstring().lpss1("abcde"));
        System.out.println(new LongestPalindromicSubstring().lpss1(""));
        System.out.println(new LongestPalindromicSubstring().lpss1("aa"));

        System.out.println("\n");

        System.out.println(new LongestPalindromicSubstring().lpss2("aaaabaa"));
        System.out.println(new LongestPalindromicSubstring().lpss2("efgabcba"));
        System.out.println(new LongestPalindromicSubstring().lpss2("mnopomn"));
        System.out.println(new LongestPalindromicSubstring().lpss2("abcde"));
        System.out.println(new LongestPalindromicSubstring().lpss2(""));
        System.out.println(new LongestPalindromicSubstring().lpss2("aa"));
    }
}
