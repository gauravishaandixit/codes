package codes.java.hashing;

import java.util.HashSet;

public class ColourfulNumber {

    boolean colorful(int A) {

        String str = Integer.toString(A);
        HashSet<Integer> hs = new HashSet();
        int p = 1;
        for(int  i = 0;i < str.length(); i++)
        {
            p = 1;
            for(int j = i; j < str.length(); j++)
            {
                p = p * Character.getNumericValue(str.charAt(j));
                if(hs.contains(p))
                    return false;
                else
                    hs.add(p);
            }
        }
        return true;
    }
}
