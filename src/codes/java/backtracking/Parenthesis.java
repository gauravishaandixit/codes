package codes.java.backtracking;

import java.util.ArrayList;

public class Parenthesis {
    ArrayList<String> ans;
    ArrayList<String> generateAllParenthesis(int n) {
        ans = new ArrayList<>();
        String comb = "";
        generate(n, n, comb);
        return ans;
    }
    void generate(int open, int close, String comb) {
        if(open < 0 || close < 0)
            return;

        if(close == 0) {
            ans.add(comb);
            return;
        }

        if(open < close) {
            generate(open - 1, close, comb + '(');
            generate(open, close - 1, comb + ')');
        }
        else {
            if (open == close)
                generate(open - 1, close, comb + '(');
        }
    }

    public static void main(String[] args) {
        System.out.println(new Parenthesis().generateAllParenthesis(1));
        System.out.println(new Parenthesis().generateAllParenthesis(2));
        System.out.println(new Parenthesis().generateAllParenthesis(3));
    }
}
