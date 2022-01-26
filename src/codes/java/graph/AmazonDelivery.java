package codes.java.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonDelivery {
    int minDistance(List<List<Integer>> area) {
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;
        dfs(0, 0, area, ans, 0);
        return ans[0] != Integer.MAX_VALUE ? ans[0] : -1;
    }

    void dfs(int i, int j, List<List<Integer>> area, int[] ans, int currDis) {
        if(i < 0 || i >= area.size() || j < 0 || j >= area.get(0).size() || area.get(i).get(j) <= 0)
            return;

        int oldValue = area.get(i).get(j);

        if(oldValue == 9) {
            ans[0] = Math.min(ans[0], currDis);
            return;
        }

        area.get(i).set(j, -1);

        dfs(i + 1, j, area, ans, currDis + 1);
        dfs(i - 1, j, area, ans, currDis + 1);
        dfs(i, j + 1, area, ans, currDis + 1);
        dfs(i, j - 1, area, ans, currDis + 1);

        area.get(i).set(j, oldValue);
    }

    public static void main(String[] args) {
        List<List<Integer>> area = new ArrayList<>();
        area.add(Arrays.asList(1, 1, 9));
        area.add(Arrays.asList(1, 1, 1));
        area.add(Arrays.asList(1, 1, 1));

        System.out.println(new AmazonDelivery().minDistance(area));
    }
}
