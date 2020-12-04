package codes.java.Hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Subsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t -- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] nums1 = new int[n];
            int[] nums2 = new int[m];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++)
                nums1[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++)
                nums2[i] = Integer.parseInt(st.nextToken());

            int lcs = LCS(nums1, nums2);
            System.out.println(n - lcs);
        }
    }

    static int LCS(int[] nums1, int[] nums2)
    {
        int m = nums1.length, n = nums2.length;
        int[][] T = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(nums1[i - 1] == nums2[j - 1])
                    T[i][j] = 1 + T[i-1][j-1];
                else
                    T[i][j] = Math.max(T[i-1][j], T[i][j-1]);
            }
        }
        return T[m][n];
    }
}
/*
1
5 6
1 2 3 4 5
2 5 6 4 9 12
 *
 *

 2
 9 19
 1 2 3 6 15 18 19 24 29
 12 19 19 5 26 2 23 9 23 14 29 7 28 24 28 29 21 16 16
 16 10
 1 2 3 4 8 9 11 12 14 17 19 21 24 26 28 29
 11 18 8 9 9 15 24 26 16 18
 */