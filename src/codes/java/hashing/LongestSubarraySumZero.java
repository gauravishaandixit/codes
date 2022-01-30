package codes.java.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LongestSubarraySumZero {
    ArrayList<Integer> longestSubarraySumZero(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int max = Integer.MIN_VALUE;

        int start = -1, end = -1;

        int sum = 0;

        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (sum == 0) {
                max = i + 1;
                start = 0;
                end = i;
            } else {
                if (!map.containsKey(sum))
                    map.put(sum, i);
                else {
                    if (i - map.get(sum) > max) {
                        max = i - map.get(sum);
                        start = map.get(sum) + 1;
                        end = i;
                    }
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();

        if (start == -1 || end == -1)
            return ans;

        for (int j = start; j <= end; j++)
            ans.add(A.get(j));

        return ans;
    }

    public static void main(String[] ar) {
        System.out.println(new LongestSubarraySumZero().longestSubarraySumZero(new ArrayList<>(Arrays.asList(1, 2, -2, 4, -4))));

    }
}
