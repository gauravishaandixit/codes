package codes.java.dp.matrixcm;

import java.util.HashMap;

public class BooleanParMemo {

    int numWays(String expr) {
        HashMap<String, Integer> memo = new HashMap<>();
        return numWaysForType(expr, 0, expr.length() - 1, 'T', memo);
    }

    int numWaysForType(String expr,int i, int j, char value, HashMap<String, Integer> memo) {
        if(i > j)
            return 0;
        if( i == j)
            return expr.charAt(i) == value ? 1 : 0;

        String key = "" + i + " " + j + " " + value;
        if(memo.containsKey(key))
            return memo.get(key);

        int ans = 0;

        for(int k = i + 1; k < j; k += 2) {
            int leftT = numWaysForType(expr, i, k - 1, 'T', memo);
            int rightT = numWaysForType(expr, k + 1, j, 'T', memo);
            int leftF = numWaysForType(expr, i, k - 1, 'F', memo);
            int rightF = numWaysForType(expr, k + 1, j, 'F', memo);

            switch (expr.charAt(k)) {
                case '|' :
                    switch (value) {
                        case 'T' : ans += (leftF * rightT +  leftT * rightF + leftT * rightT); break;
                        case 'F' : ans += (leftF * rightF); break;
                    }
                    break;
                case '&' :
                    switch (value) {
                        case 'T' : ans += (leftT * rightT); break;
                        case 'F' : ans += (leftF * rightT + leftT * rightF + leftF * rightF); break;
                    }
                    break;
                case '^' :
                    switch (value) {
                        case 'T' : ans += (leftF * rightT + leftT * rightF); break;
                        case 'F' : ans += (leftT * rightT + leftF * rightF); break;
                    }
                    break;
            }
        }
        memo.put(key, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new BooleanParMemo().numWays("T|T&F^T")); // 4
        System.out.println(new BooleanParMemo().numWays("T^F&T")); // 2
        System.out.println(new BooleanParMemo().numWays("T^F|F")); // 2
    }
}
