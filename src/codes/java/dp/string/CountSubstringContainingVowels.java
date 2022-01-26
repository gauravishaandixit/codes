package codes.java.dp.string;

import codes.java.Helper.PrintArray;

import java.util.Arrays;

// https://leetcode.com/problems/vowels-of-all-substrings/

public class CountSubstringContainingVowels {
    int countSubstring(String s) {
        int n = s.length();

        if(n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (isVowel(s.charAt(i - 1))) {
                dp[i] = dp[i - 1] + (i);
            } else {
                dp[i] = dp[i - 1];
            }
        }

        //PrintArray.printArray(dp);

        return Arrays.stream(dp).sum();
    }

    boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static void main(String[] args) {
        System.out.println(new CountSubstringContainingVowels().countSubstring("aba"));
        System.out.println(new CountSubstringContainingVowels().countSubstring("abc"));
        System.out.println(new CountSubstringContainingVowels().countSubstring("dbc"));
    }
}
