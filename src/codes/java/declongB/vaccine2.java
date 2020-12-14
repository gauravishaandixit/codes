package codes.java.declongB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class vaccine2 {
    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            if(d == 1)
            {
                System.out.println(n);
                continue;
            }

            int risk = 0;
            int noRisk = 0;

            while(st.hasMoreTokens())
            {
                int age = Integer.parseInt(st.nextToken());
                if(age > 9 && age < 80)
                    noRisk++;
                else
                    risk++;
            }

            System.out.println((int)(Math.ceil(risk/(d * 1.0)) + Math.ceil(noRisk/(d * 1.0))));
        }
    }
}
