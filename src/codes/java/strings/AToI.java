package codes.java.strings;

public class AToI {
    int atoi(String str) {

        str = str.trim();

        if(str.length()==0)
            return 0;

        char sign = str.charAt(0);

        if(sign == '+' || sign == '-')
            str = str.substring(1);

        if(str.length()==0)
            return 0;

        if(!Character.isDigit(str.charAt(0)))
            return 0;

        String num = "";
        num += sign == '-' ? '-': "";


        int i = 0;
        while(i < str.length())
        {
            char ch = str.charAt(i);
            if(Character.isDigit(ch))
                num = num + ch;
            else
                break;
            i++;
        }

        long val;
        try
        {
            val = Long.parseLong(num);
        }
        catch(Exception e)
        {
            return sign == '-'? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        if(val < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        if(val > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return Integer.parseInt(num);
    }
}
