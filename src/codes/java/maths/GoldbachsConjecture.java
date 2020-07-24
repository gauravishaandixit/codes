package codes.java.maths;

public class GoldbachsConjecture {

    public int[] primesum(int n) {

        boolean isPrime[]=new boolean[n + 1];

        SieveOfEratosthenes(n, isPrime);

        for (int i = 0; i < n; i++)
        {
            if (isPrime[i] && isPrime[n - i])
                return new int[]{i, n - i};
        }

        return new int[2];
    }
    static boolean SieveOfEratosthenes(int n, boolean isPrime[])
    {
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= n; i++)
            isPrime[i] = true;

        for (int p = 2; p * p <= n; p++)
        {
            if (isPrime[p] == true)
            {
                for (int i = p * p; i <= n; i += p)
                    isPrime[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] a)
    {
        int ans[] = new GoldbachsConjecture().primesum(100);
        System.out.println(ans[0] +" "+ans[1]);

        ans = new GoldbachsConjecture().primesum(12345678);
        System.out.println(ans[0] +" "+ans[1]);
    }
}
