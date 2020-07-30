package codes.java.strings;

import java.util.HashMap;

public class LongestSubstringWithoutRepeat {

    int lengthOfLongestSubstring(String s) {

        if(s.length() == 0)
            return 0;

        HashMap<Character, Integer> hm = new HashMap<>();

        int ans = 0;
        int i = 0;
        int j = 0;

        while(i < s.length())
        {
            if(hm.containsKey(s.charAt(i)))
                j = Math.max(j, hm.get(s.charAt(i)) + 1);

            hm.put(s.charAt(i),i);

            ans = Math.max(ans, i - j + 1);

            i++;
        }
        return ans;
    }
}
