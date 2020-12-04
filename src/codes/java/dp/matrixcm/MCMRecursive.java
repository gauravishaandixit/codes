package codes.java.dp.matrixcm;

public class MCMRecursive {

    int mcmRecursive(int arr[])
    {
        int n = arr.length;
        return mcmRecursiveHelper(arr, 0, n - 2);
    }

    int mcmRecursiveHelper(int arr[], int i, int j)
    {
        if(i >= j)
            return 0;

        int ans = Integer.MAX_VALUE;

        for(int k = i; k < j; k++)
        {
            int val = mcmRecursiveHelper(arr, i, k) + mcmRecursiveHelper(arr, k + 1, j)
                    + (arr[i] * arr[k + 1] * arr[j + 1]);
            ans = Math.min(ans, val);
        }
        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(new MCMRecursive().mcmRecursive(new int[]{1,2,3,4,3}));
        System.out.println(new MCMRecursive().mcmRecursive(new int[]{40, 20, 30, 10, 30}));
        System.out.println(new MCMRecursive().mcmRecursive(new int[]{10, 20, 30, 40, 30}));
        System.out.println(new MCMRecursive().mcmRecursive(new int[]{10, 20}));
        System.out.println(new MCMRecursive().mcmRecursive(new int[]{10, 20, 30}));
    }
}