package codes.java.strings;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChar {
    String longestSubstring(String str)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = str.length();

        int start = 0;
        int maxLen = 0;

        for(int i = 0, j = 0; i < n; i++)
        {
            char ch = str.charAt(i);
            if(map.containsKey(ch))
                j = Math.max(j, map.get(ch) + 1);

            if(maxLen < i - j + 1)
            {
                start = j;
                maxLen = i - j + 1;
            }
            map.put(ch, i);
        }
        return str.substring(start, start + maxLen);
    }

    public static void main(String[] args)
    {
        System.out.println(new LongestSubstringWithoutRepeatingChar().longestSubstring(""));
        System.out.println(new LongestSubstringWithoutRepeatingChar().longestSubstring("A"));
        System.out.println(new LongestSubstringWithoutRepeatingChar().longestSubstring("ABCDEF"));
        System.out.println(new LongestSubstringWithoutRepeatingChar().longestSubstring("AABGCDEFE"));
        System.out.println(new LongestSubstringWithoutRepeatingChar().longestSubstring("CODINGISAWESOME"));
        System.out.println(new LongestSubstringWithoutRepeatingChar().longestSubstring("always be coding"));
    }
}
