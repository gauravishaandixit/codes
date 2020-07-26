package codes.java.strings;

import java.util.HashMap;

public class RomanToInteger {
    int romanToInt(String str) {

        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);

        if (str.length() <= 1)
            return hm.get(str.charAt(0));
        int res = 0, i = 0;
        while (i < str.length()) {
            if (i != str.length() - 1 && hm.get(str.charAt(i)) < hm.get(str.charAt(i + 1))) {
                res += hm.get(str.charAt(i + 1)) - hm.get(str.charAt(i));
                i = i + 2;
            } else {
                res += hm.get(str.charAt(i));
                i = i + 1;
            }
        }
        return res;
    }
}
