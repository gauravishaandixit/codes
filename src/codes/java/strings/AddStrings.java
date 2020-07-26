package codes.java.strings;

public class AddStrings {

    String addString(String s1, String s2)
    {
        int m = s1.length(), n = s2.length();
        int i = m - 1, j = n - 1;
        int sum = 0;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while( i >= 0 || j >= 0)
        {
            sum = 0;
            if(i >= 0)
                sum += s1.charAt(i) - '0';

            if(j >= 0)
                sum += s2.charAt(j) - '0';

            sum += carry;
            sb.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        if(carry > 0)
            sb.append(carry);

        return sb.reverse().toString();
    }

    public static void main(String[] a)
    {
        System.out.println(new AddStrings().addString("123","456"));
        System.out.println(new AddStrings().addString("456","456"));
        System.out.println(new AddStrings().addString("456","6"));
        System.out.println(new AddStrings().addString("6","456"));
        System.out.println(new AddStrings().addString("1","999"));
        System.out.println(new AddStrings().addString("0","1"));
        System.out.println(new AddStrings().addString("9999999999999999999999999999","9999999999999999999999999999999"));
    }
}
