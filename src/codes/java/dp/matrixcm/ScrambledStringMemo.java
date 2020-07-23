package codes.java.dp.matrixcm;

import java.util.HashMap;
import java.util.Map;

public class ScrambledStringMemo {
    Map<String, Boolean> memo = new HashMap<>();

    boolean isScrambled(String s1, String s2)
    {
        if(s1 == null || s2 == null)
            return false;

        if(s1.length() != s2.length())
            return false;

        if(s1.equals(s2))
            return true;

        int[] letters = new int[26];

        for(int i = 0; i < s1.length(); i++)
        {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; i++)
        {
            if(letters[i] != 0)
                return false;
        }

        String key = s1 + " " + s2;
        if(memo.containsKey(key))
            return memo.get(key);

        for(int k = 1; k < s1.length() - 1; k++)
        {
            if(isScrambled(s1.substring(0,k), s2.substring(0,k)) && isScrambled(s1.substring(k), s2.substring(k)))
            {
                memo.put(key, true);
                return true;
            }

            if(isScrambled(s1.substring(0,k), s2.substring(s1.length() - k)) && isScrambled(s1.substring(k), s2.substring(0,s1.length() - k)))
            {
                memo.put(key, true);
                return true;
            }
        }
        memo.put(key, false);
        return false;
    }

    public static void main(String[] args)
    {
        System.out.println(new ScrambledStringMemo().isScrambled("great","eatgr"));
        System.out.println(new ScrambledStringMemo().isScrambled("great","aterg"));
        System.out.println(new ScrambledStringMemo().isScrambled("great","gerta"));
        System.out.println(new ScrambledStringMemo().isScrambled("great","taerg"));
    }
}
