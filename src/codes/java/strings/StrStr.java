package codes.java.strings;

public class StrStr {

    int strStr(String s, String t)
    {
        if (t.isEmpty()) return 0;
        for (int i = 0; i <= s.length() - t.length(); i++) {
            for (int j = 0; j < t.length() && s.charAt(i + j) == t.charAt(j); j++)
                if (j == t.length() - 1)
                    return i;
        }
        return -1;
    }
}
