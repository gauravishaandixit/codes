package codes.java.dp.matrixcm;


//Will give TLE for large testcases
//Time Complexity:: n * 2 ^ n
public class EggDroppingRecursive {
    int minNoWays(int eggs, int floors)
    {
        if(floors <= 1 || eggs == 1)
            return floors;

        int ans = Integer.MAX_VALUE;

        for(int k = 1; k <= floors; k++)
        {
            int curr = 1 + Math.max(minNoWays(eggs - 1, k - 1), minNoWays(eggs, floors - k));
            ans = Math.min(curr, ans);
        }
        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(new EggDroppingRecursive().minNoWays(1, 5));
        System.out.println(new EggDroppingRecursive().minNoWays(2, 5));
        System.out.println(new EggDroppingRecursive().minNoWays(6, 5));
        System.out.println(new EggDroppingRecursive().minNoWays(10000, 965));
    }
}
