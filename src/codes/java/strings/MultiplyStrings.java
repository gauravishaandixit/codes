package codes.java.strings;

public class MultiplyStrings {
    String multiplyString(String s1, String s2)
    {
        int m = s1.length(), n = s2.length();

        int ans[] = new int[m + n];
        for(int i = m - 1; i >= 0; i--)
        {
            for(int j = n - 1; j >= 0; j--)
            {
                int product = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
                int pPosn = i + j + 1;
                int cPosn = i + j;

                int sum = product + ans[pPosn];
                ans[pPosn] = sum % 10;
                ans[cPosn] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int num : ans)
        {
            if(sb.length() != 0 || num != 0)
                sb.append(num);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(new MultiplyStrings().multiplyString("1","2"));
        System.out.println(new MultiplyStrings().multiplyString("12345","0000"));
        System.out.println(new MultiplyStrings().multiplyString("10","12"));
        System.out.println(new MultiplyStrings().multiplyString("11","123"));
        System.out.println(new MultiplyStrings().multiplyString("84","67453"));
    }
}
