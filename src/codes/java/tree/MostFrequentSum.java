package codes.java.tree;


import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/most-frequent-subtree-sum/
public class MostFrequentSum {

    HashMap<Integer, Integer> map;
    int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        calcSum(root);

        int max = 0;
        int count = 0;
        for(Map.Entry<Integer, Integer> me : map.entrySet())
            max = Math.max(max, me.getValue());

        for(Map.Entry<Integer, Integer> me : map.entrySet())
            if(me.getValue() == max)
                count++;

        int ans[] = new int[count];
        count = 0;

        for(Map.Entry<Integer, Integer> me : map.entrySet())
            if(me.getValue() == max)
                ans[count++] = me.getKey();


        return ans;
    }

    int calcSum(TreeNode root)
    {
        if(root == null)
            return 0;

        int sum = root.val + calcSum(root.left) + calcSum(root.right);
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        return sum;
    }
}
