package codes.java.Hackerearth.CodeVita;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LargestGold {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] lengths = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            lengths[i] = Integer.parseInt(st.nextToken());

        int mod = (int) 1e9 + 7;
        long totalVolume = Arrays.stream(lengths).sum() * w * h;
        long maxVolume = largestRectangleArea(lengths) * w * h;
        System.out.println((totalVolume - maxVolume) % mod);
    }

    static long largestRectangleArea(int[] arr) {

        Stack<Integer> st = new Stack<>();
        long ans = 0;
        int i = 0;
        long curr_area = 0;
        int n = arr.length;

        while(i < n)
        {
            if(st.isEmpty() || arr[i] >= arr[st.peek()])
                st.push(i++);
            else
            {
                int height = arr[st.pop()];
                int width = (st.isEmpty()? i : i - st.peek() - 1);
                curr_area = height * width;
                ans = Math.max(ans, curr_area);
            }
        }
        while(!st.isEmpty())
        {
            int height = arr[st.pop()];
            int width = (st.isEmpty()? n : n - st.peek() - 1);
            curr_area = height * width;
            ans = Math.max(ans, curr_area);
        }
        return ans;
    }
}
