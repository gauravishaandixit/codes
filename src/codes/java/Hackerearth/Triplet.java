package codes.java.Hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Triplet {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- >0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());


            ArrayList<int[]> ans = new ArrayList<>();
            int maxxSum = Integer.MIN_VALUE;
            int i = 0;
            while(i < n)
            {
                int j = i + 1, k = n - 1;
                while(j < k)
                {
                    if(arr[i] <= arr[j] && arr[j] <= arr[k])
                    {

                    }
                }
            }
        }
    }

}
