package codes.java.dp.matrixcm;

public class ScrambledStringRecusrive {

    boolean isScrambled(String s1, String s2)
    {
        if(s1 == null || s2 == null)
            return false;

        if(s1.length() != s2.length())
            return false;

        if(s1.equals(s2))
            return true;

        int[] letters = new int[26];

        for(int i = 0; i < s1.length(); i++)
        {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; i++)
            if(letters[i] != 0)
                return false;

        for(int k = 1; k < s1.length() - 1; k++)
        {
            if(isScrambled(s1.substring(0,k), s2.substring(0,k)) && isScrambled(s1.substring(k), s2.substring(k)))
                return true;

            if(isScrambled(s1.substring(0,k), s2.substring(s1.length() - k)) && isScrambled(s1.substring(k), s2.substring(0,s1.length() - k)))
                return true;
        }

        return false;
    }

    public static void main(String[] args)
    {
        System.out.println(new ScrambledStringRecusrive().isScrambled("great","eatgr"));
        System.out.println(new ScrambledStringRecusrive().isScrambled("great","aterg"));
        System.out.println(new ScrambledStringRecusrive().isScrambled("great","gerta"));
        System.out.println(new ScrambledStringRecusrive().isScrambled("great","taerg"));
    }

}
