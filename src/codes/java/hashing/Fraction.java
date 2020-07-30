package codes.java.hashing;

import java.util.HashMap;
import java.util.Map;

public class Fraction {

    String fractionToDecimal(long A, long B) {
        long num=Math.abs(A);
        long den=Math.abs(B);

        if(num == 0)
            return "0";
        StringBuilder sb = new StringBuilder();

        if((A < 0 && B > 0) || (A > 0 && B < 0))
            sb.append("-");

        long initial=num/den;
        sb.append(initial);
        if(num%den==0)
            return sb.toString();

        sb.append(".");
        long rem=num%den;

        Map<Long, Long> map= new HashMap<>();
        long index=0;
        boolean repeat=false;
        while (rem > 0 && !repeat)
        {     // checking if remainder repeats.
            if(map.containsKey(rem))
            {
                index=map.get(rem);
                repeat=true;
                break;
            }
            else
                map.put(rem,(long)sb.length());

            rem *= 10;
            long temp=rem/den;     // divide the remainder by denominater.
            sb.append(temp);
            rem=rem%den;          // calculate the next remainder (remainder of remainder)
        }

        if (repeat)
        {               // if repeated insert "()"
            sb.insert((int) index,"(");
            sb.append(")");
        }
        return sb.toString();
    }
}
