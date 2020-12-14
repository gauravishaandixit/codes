package codes.java.declongB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class evenpairsum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while( t--> 0 )
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int evenA = A/2;
            int oddA = A - evenA;

            int evenB = B/2;
            int oddB = B - evenB;

            System.out.println(evenA * evenB + oddA * oddB);
        }
    }
}
