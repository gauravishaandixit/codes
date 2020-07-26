package codes.java.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchInRotatedArray {

    public int search(ArrayList<Integer> a, int target)
    {
        return binarySearch(a, 0, a.size()-1, target);
    }

    public int binarySearch(ArrayList<Integer> a, int start, int end, int target) {

        while (start <= end)
        {
            int mid = (start + end)/2;
            if (a.get(mid) == target)
                return mid;
            if (a.get(start) <= a.get(mid))
            {
                if (target >= a.get(start) && a.get(mid) >= target)
                    end = mid-1;
                else
                    start = mid+1;
            }
            else
            {
                if (a.get(mid+1) <= target && a.get(end) >= target)
                    start = mid+1;
                else
                    end = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args)
    {
        ArrayList<Integer> arr = new ArrayList();
        for(int i = 9; i >= 5; i--)
            arr.add(i);

        for(int i = 1; i < 5; i++)
            arr.add(i);

        System.out.println(arr);
        System.out.println(new SearchInRotatedArray().search(arr, 8));
        System.out.println(new SearchInRotatedArray().search(arr, 4));
    }
}
