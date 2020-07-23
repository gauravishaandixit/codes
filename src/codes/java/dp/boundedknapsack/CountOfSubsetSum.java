package codes.java.dp.boundedknapsack;

public class CountOfSubsetSum {

    int subsetSum(int[] arr, int S)
    {
        int n = arr.length;
        int T[][] = new int[n + 1][S + 1];
        for(int i = 0; i <= n; i++)
            T[i][0] = 1;

        for(int j = 1; j <= S; j++)
            T[0][j] = 0;

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j<= S; j++)
            {
                T[i][j] = T[i-1][j];
                if(arr[i-1] <= j)
                    T[i][j] += T[i-1][j - arr[i-1]];
            }
        }

        return T[n][S];
    }

    public static void main(String[] args)
    {
        int set[] = new int[]{1, 2, 4, 5, 7};
        int S = 8;
        System.out.println(new CountOfSubsetSum().subsetSum(set, S));

        S = 20;
        System.out.println(new CountOfSubsetSum().subsetSum(set, S));

        S = 0;
        System.out.println(new CountOfSubsetSum().subsetSum(set, S));
    }
}
