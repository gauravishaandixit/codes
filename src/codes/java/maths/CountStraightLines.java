package codes.java.maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CountStraightLines {

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int hx = Integer.parseInt(st.nextToken());
        int hy = Integer.parseInt(st.nextToken());

        HashSet<Double> set = new HashSet<>();

        for(int i = 1; i <= n; i++)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            double m = (hy - y)/((hx - x) * 1.0);
            set.add(m);
        }

        System.out.println(set.size());
    }
}