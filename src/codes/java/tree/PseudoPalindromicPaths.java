package codes.java.tree;

public class PseudoPalindromicPaths {
    int result;
    int countPseudoPalindromicPaths(TreeNode root)
    {
        result = 0;
        if(root == null)
            return 0;
        int[] freqMap = new int[10];
        countPaths(root, freqMap);
        return result;
    }

    void countPaths(TreeNode root, int[] freqMap)
    {
        if(root == null)
            return;

        freqMap[root.val]++;
        if(root.left == null && root.right == null)
        {
            if(checkPseudoPalindrome(freqMap))
                result++;
        }

        countPaths(root.left, freqMap);
        countPaths(root.right, freqMap);

        freqMap[root.val]--;
    }

    boolean checkPseudoPalindrome(int[] freqMap)
    {
        int odd = 0;
        for(int i = 0; i < 10; i++)
        {
            if((freqMap[i] & 1) == 1)
                odd++;

            if(odd > 1)
                return false;
        }

        return true;
    }
}
