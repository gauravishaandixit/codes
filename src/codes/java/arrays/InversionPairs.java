package codes.java.arrays;

public class InversionPairs {

    private int countIP(int[] arr)
    {
        int ans = 0;
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = i + 1; j < arr.length; j++)
            {
                if(arr[i] > arr[j])
                    ans++;
            }
        }
        return ans;
    }

    private int countInversionPair(int[] arr)
    {
        int[] temp = new int[arr.length];
        return mergeSort(arr, 0, arr.length - 1, temp);
    }

    private int mergeSort(int[] arr, int l, int r, int[] temp)
    {
        int count = 0;
        if(l < r)
        {
            int mid = (l + r) / 2;

            count += mergeSort(arr, l, mid, temp);
            count += mergeSort(arr, mid + 1, r, temp);

            count += merge(arr, l, mid, r, temp);
        }
        return count;
    }

    private int merge(int[] arr, int l, int mid, int r, int[] temp)
    {
        int invCount = 0;
        int i = l, j = mid + 1;
        int k = l;

        while(i <= mid && j <= r)
        {
            if(arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
            {
                temp[k++] = arr[j++];
                invCount += (mid - i + 1);
            }
        }

        while(i <= mid)
            temp[k++] = arr[i++];

        while(j <= r)
            temp[k++] = arr[j++];

        for(i = l; i <= r; i++)
            arr[i] = temp[i];

        return invCount;
    }


    public static void main(String[] ar)
    {
        int[] arr = new int[]{1, 20, 6, 4, 5};
        System.out.println(new InversionPairs().countIP(arr));
        System.out.println(new InversionPairs().countInversionPair(arr));

        arr = new int[]{2, 4, 1, 3, 5};
        System.out.println(new InversionPairs().countIP(arr));
        System.out.println(new InversionPairs().countInversionPair(arr));
    }
}
