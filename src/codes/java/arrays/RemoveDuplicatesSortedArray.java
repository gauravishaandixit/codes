package codes.java.arrays;

public class RemoveDuplicatesSortedArray {
    int removeDuplicates(int[] arr)
    {
        int n = arr.length;
        int i = 1, j = 1;
        for(; i < n;)
        {
            while(i < n && arr[i] == arr[i - 1])
                i++;
            if(i == n)
                break;
            arr[j++] = arr[i++];
        }
        return j;
    }
    void printArray(int arr[], int l)
    {
        for(int i = 0; i < l; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String[] ar)
    {
        int arr[] = new int[]{1,1,1,1,2,3,4,4,4,5};
        new RemoveDuplicatesSortedArray().printArray(arr, new
                RemoveDuplicatesSortedArray().removeDuplicates(arr));

    }
}
