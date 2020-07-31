package codes.java.dp.lis;

// Given an array of integer numbers, we need to sort this array in a minimum number of steps
// where in one step we can insert any array element from its position to any other position.
public class MinInsertionToMakeSortedArray {
    int minInsertion(int[] arr)
    {
        return arr.length - new LIS().lis(arr);
    }

    public static void main(String[] ar)
    {
        System.out.println(new MinInsertionToMakeSortedArray().minInsertion(new int[]{2, 3, 5, 1, 4, 7, 6}));
        System.out.println(new MinInsertionToMakeSortedArray().minInsertion(new int[]{2, 3, 5, 1, 4, 7, 6, 0}));
        System.out.println(new MinInsertionToMakeSortedArray().minInsertion(new int[]{2, 3, 5, 6, 4, 7, 6, 8}));
    }
}
