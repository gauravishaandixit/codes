package codes.java.strings;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/partition-labels/

public class PartitionLabel {
    List<Integer> partitionLabels(String s) {
        if(s == null || s.length() == 0)
            return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();

        int[] lastIndex = new int[26];
        for(int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        int last = -1;
        int start = -1;

        for(int i = 0; i < s.length(); i++) {
            last = Math.max(last, lastIndex[s.charAt(i) - 'a']);
            if(last == i) {
                ans.add(last - start + 1);
                start = i + 1;
            }
        }

        return ans;
    }
}
