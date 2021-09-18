package codes.java.backtracking;

import java.util.ArrayList;
import java.util.HashMap;

public class LetterPhone {
    ArrayList<String> letterCombinations(String digits)
    {
        ArrayList<String> ans = new ArrayList<>();
        HashMap<Character, String> keyPad = new HashMap<>();
        keyPad.put('0', "0");
        keyPad.put('1', "1");
        keyPad.put('2', "abc");
        keyPad.put('3', "def");
        keyPad.put('4', "ghi");
        keyPad.put('5', "jkl");
        keyPad.put('6', "mno");
        keyPad.put('7', "pqrs");
        keyPad.put('8', "tuv");
        keyPad.put('9', "wxyz");
        findAll(digits, new StringBuilder(), ans, keyPad);
        return ans;
    }

    void findAll(String digits, StringBuilder sb, ArrayList<String> ans, HashMap<Character, String> keyPad)
    {
        if(sb.length() == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        char curr = digits.charAt(sb.length());
        for(char ch: keyPad.get(curr).toCharArray()) {
            sb.append(ch);
            findAll(digits, sb, ans, keyPad);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] ar)
    {
        System.out.println(new LetterPhone().letterCombinations("23"));
        System.out.println(new LetterPhone().letterCombinations("672"));
        System.out.println(new LetterPhone().letterCombinations("4836"));
    }
}
