package codes.java.arrays;

import java.util.Arrays;

public class SkyLine {

    void height(int[] left, int[] bottom)
    {
        int m = left.length;
        int n = bottom.length;

        int hMax = 0;
        int hMin = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                hMax += Math.min(left[i], bottom[j]);
            }
        }

        hMin += Arrays.stream(bottom).sum();
        for(int i = 1; i < m; i++)
            hMin += left[i];
        System.out.println(hMin + " " + hMax);

    }

    public static void main(String[] ar)
    {
        new SkyLine().height(new int[]{5,4}, new int[]{1,2,5});
        new SkyLine().height(new int[]{3,5}, new int[]{3,3,5});
    }
}
