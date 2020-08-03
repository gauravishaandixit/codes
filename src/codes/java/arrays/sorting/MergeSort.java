package codes.java.arrays.sorting;

public class MergeSort {

    void mergeSort(int[] arr)
    {
        mergeSort(arr, 0, arr.length - 1);
    }

    void mergeSort(int[] arr, int l, int r)
    {
        if(l < r)
        {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    void merge(int[] arr, int l, int mid, int r)
    {
        int[] temp = new int[r - l + 1];
        int i = l, j = mid + 1;
        int k = 0;

        while(i <= mid && j <= r)
        {
            if(arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while(i <= mid)
            temp[k++] = arr[i++];

        while (j <= r)
            temp[k++] = arr[j++];

        for(i = l; i <= r; i++)
            arr[i] = temp[i - l];
    }

    static void printArray(int[] arr)
    {
        for(int a: arr)
            System.out.print(a +" ");

        System.out.print("\n");
    }

    public static void main(String[] ar)
    {
        int[] arr = new int[]{5,4,3,2,1};
        new MergeSort().mergeSort(arr);
        printArray(arr);

        arr = new int[]{8,2,4,9,7,6,4,3,8,1,2,4,5};
        new MergeSort().mergeSort(arr);
        printArray(arr);
    }

}
