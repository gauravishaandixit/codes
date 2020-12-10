package codes.java.declongB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class vaccine1 {
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 1; //Integer.parseInt(br.readLine());
        while( t--> 0 )
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d1 = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());
            int d2 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            if(d1 == d2)
            {
                int  req = (int)Math.ceil(p / ((v1 + v2) * 1.0));
                System.out.println(d1 + req -1);
            }
            else
            {
                p = p - Math.abs(d1 - d2) * (d1 < d2 ? v1: v2);
                int req = (int) Math.ceil(p / ((v1 + v2) * 1.0));
                System.out.println(Math.min(d1, d2) + Math.abs(d1 - d2) + req - 1);
            }
        }
    }
}
