package codes.java.arrays;

//  1 2 3 -> 1 3 2
//  3 2 1 -> 1 2 3
public class NextLargestPermutation {

    public int[] nextPermutation(int[] arr)
    {
        int n = arr.length;
        int i = n - 2;

        while(i >= 0 && arr[i] >= arr[i + 1])
            i--;

        if(i >= 0)
        {
            int j = n - 1;
            while(arr[j] <= arr[i])
                j--;

            swap(arr, i , j);
        }

        reverse(arr, i + 1, n - 1);
        return arr;
    }

    void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void reverse(int[] arr, int i, int j)
    {
        while(i < j)
            swap(arr, i++, j--);
    }

    void printArray(int arr[])
    {
        for(int a: arr)
            System.out.print(a + " ");

        System.out.println();
    }
    public static void main(String[] args)
    {
        int arr[] = new int[]{3, 4, 2, 8, 5, 7, 6};
        int ans[] = new NextLargestPermutation().nextPermutation(arr);
        new NextLargestPermutation().printArray(ans);

        arr = new int[]{3, 4, 2, 8, 10, 7, 6};
        ans = new NextLargestPermutation().nextPermutation(arr);
        new NextLargestPermutation().printArray(ans);

        arr = new int[]{1, 2, 3};
        ans = new NextLargestPermutation().nextPermutation(arr);
        new NextLargestPermutation().printArray(ans);

        arr = new int[]{3, 2, 1};
        ans = new NextLargestPermutation().nextPermutation(arr);
        new NextLargestPermutation().printArray(ans);
    }
}
