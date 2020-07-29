package codes.java.backtracking;

import java.util.ArrayList;

public class PalindromePartioning {

    ArrayList<ArrayList<String>> allPartition(String str)
    {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        findAll(0, str, new ArrayList<>(), ans);
        return ans;
    }

    void findAll(int s, String str, ArrayList<String> curr, ArrayList<ArrayList<String>> ans)
    {
        if(s == str.length())
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = s; i < str.length(); i++)
        {
            String sub = str.substring(s, i + 1);
            if(isPalindrome(sub))
            {
                curr.add(sub);
                findAll(i + 1, str, curr, ans);
                curr.remove(curr.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s)
    {
        int left = 0, right = s.length() - 1;

        while(left <= right)
        {
            if(s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }
    public static void main(String[] ar)
    {
        System.out.println(new PalindromePartioning().allPartition("aab"));
        System.out.println(new PalindromePartioning().allPartition("aabaa"));
    }
}
