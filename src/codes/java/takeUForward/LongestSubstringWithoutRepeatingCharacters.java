package codes.java.takeUForward;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    int longestSubstringWithoutRepeatingCharacters(String str) {
        int ans = 1;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        while(right < str.length()) {
            char ch = str.charAt(right);

            if(map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1); // +1 to make it point to next to repeating character
            }
            map.put(ch, right);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
