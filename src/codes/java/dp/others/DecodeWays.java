package codes.java.dp.others;

public class DecodeWays {

    public int numDecodings(String s) {
        if(s.charAt(0) == '0')
            return 0;

        int n = s.length();
        int[] T = new int[n];
        T[0] = 1;

        for(int i = 1; i < n; i++)
        {
            /*
            if(s.charAt(i) > '0')
                T[i] += T[i - 1];

            if(s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) <= '6'))
                    T[i] += (i == 1 ? 1 : T[i-2]);
            */

            int first = Integer.parseInt(s.substring(i, i+1));
            int second = Integer.parseInt(s.substring(i-1, i+1));

            //System.out.println(first + " " + second);

            if(first >= 1 && first <= 9)
                T[i] += T[i-1];

            if(second >= 10 && second <= 26)
                T[i] += (i >=2 ? T[i-2] : 1);
        }

        return T[n-1];

    }
}
