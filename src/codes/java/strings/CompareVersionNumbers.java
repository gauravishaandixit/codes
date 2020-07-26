package codes.java.strings;

import java.util.ArrayList;
import java.util.Arrays;

public class CompareVersionNumbers {
    public int compareVersion(String v1, String v2) {

        ArrayList<String> arr1 = new ArrayList<>(Arrays.asList(v1.split("\\.")));
        ArrayList<String> arr2 = new ArrayList<>(Arrays.asList(v2.split("\\.")));

        while(arr1.size() < arr2.size())
            arr1.add("0");

        while(arr2.size() < arr1.size())
            arr2.add("0");



        int i = 0;
        while(i < arr1.size())
        {
            int compare = compareTwo(arr1.get(i), arr2.get(i));
            if(compare == -1)
                return -1;
            else
            if(compare == 1)
                return 1;
            i++;
        }
        return 0;
    }

    int compareTwo(String s1, String s2)
    {
        s1 = trimLeadingZeroes(s1);
        s2 = trimLeadingZeroes(s2);


        if(Integer.parseInt(s1) < Integer.parseInt(s2))
            return -1;
        if(Integer.parseInt(s1) > Integer.parseInt(s2))
            return 1;
        return 0;
    }

    String trimLeadingZeroes(String str)
    {
        StringBuilder sb = new StringBuilder(str);
        for(int i = 0; i < sb.length();)
        {
            if(sb.charAt(i) != '0')
                break;
            else
                sb.deleteCharAt(i);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
