package codes.java.hashing;

import java.util.*;

public class GroupAnagrams {

    ArrayList<ArrayList<Integer>> groupAnagrams(final List<String> A) {

        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0; i < A.size(); i++)
        {
            String sSorted = getSortedString(A.get(i));
            map.computeIfAbsent(sSorted, k -> new ArrayList<>()).add(i);
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }

    String getSortedString(String s)
    {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }
    public static void main(String[] args)
    {
        System.out.println(new GroupAnagrams().groupAnagrams(Arrays.asList("cat", "tac", "dog", "god")));
    }
}
