package codes.java.dp.lis;

import java.util.Arrays;

public class BoxStacking {
    class Box
    {
        int l, w, h, area;
        Box(int length, int width, int height)
        {
            l = length;
            w = width;
            h = height;

            area = length * width;
        }
        public String toString()
        {
            return l + " " +w+ " " + h+ " " + area;
        }
    }
    public int maxHeight(int height[], int width[], int length[], int n)
    {
        Box[] boxes = new Box[n];
        for(int i = 0; i < n; i++)
            boxes[i] = new Box(length[i], width[i], height[i]);

        Box[] rotatedBoxes = new Box[3 * n];
        for(int i = 0; i < n; i++)
        {
            Box box = boxes[i];

            rotatedBoxes[3*i] = new Box(Math.max(box.l, box.w), Math.min(box.l,box.w), box.h);

            rotatedBoxes[3*i + 1] = new Box(Math.max(box.l, box.h), Math.min(box.l,box.h), box.w);

            rotatedBoxes[3*i + 2] = new Box(Math.max(box.h, box.w), Math.min(box.h,box.w), box.l);
        }

        Arrays.sort(rotatedBoxes, (a, b) -> b.area - a.area);
        //System.out.println(rotatedBoxes);

        int size = 3 * n;
        int msh[] = new int[size];

        for(int i = 0; i < size; i++)
            msh[i] = rotatedBoxes[i].h;


        int maxHeight = 0;

        for(int i = 1; i < size; i++)
        {
            Box currBox = rotatedBoxes[i];
            for(int j = 0; j < i; j++)
            {
                Box prevBox = rotatedBoxes[j];
                if((currBox.l < prevBox.l && currBox.w < prevBox.w))
                    msh[i] = Math.max(msh[i], msh[j] + currBox.h);
            }
            maxHeight = Math.max(msh[i], maxHeight);
        }

        return maxHeight;

    }
}
