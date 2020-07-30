package codes.java.backtracking;

// https://leetcode.com/problems/word-break-ii/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WordBreak2 {

    public List<String> wordBreak(String s, List<String> wordDict)
    {
        HashMap<String, List<String>> map = new HashMap<>();

        return doBackTrack(s, wordDict, map);
    }
    List<String> doBackTrack(String s, List<String> wordDict, HashMap<String, List<String>> map)
    {
        if(map.containsKey(s))
            return map.get(s);

        List<String> res = new LinkedList<>();
        if(s.length() == 0)
        {
            res.add("");
            return res;
        }

        for(String word: wordDict)
        {
            if(s.startsWith(word))
            {
                List<String> sublist = doBackTrack(s.substring(word.length()), wordDict, map);
                for(String st: sublist)
                    res.add(word + (st.isEmpty() ? "" : " ") + st);
            }
        }
        map.put(s, res);
        return res;
    }
}
