package codes.java.Hackerearth.CodeVita;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EvenOdd {
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        combine(m,n,k);
        System.out.println(res);
    }



    static ArrayList<ArrayList<Integer>> combine(int m, int n, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        findCombinations(new ArrayList<>(), m, n, k);
        return ans;
    }

    static void findCombinations(ArrayList<Integer> arr, int curr, int n, int k)
    {
        if(k == 0)
        {
            long sum = 0;
            for(int a: arr)
                sum += a;
            if((sum & 1) == 0)
                res++;
            return;
        }
        for(int i = curr; i <= n; i++)
        {
            arr.add(i);
            findCombinations(arr, curr, n, k - 1);
            arr.remove(arr.size()-1);
        }
    }
}
