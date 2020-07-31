package codes.java.dp.lis;

public class MinDeletionsToMakeSortedSequence {

    int minDeletions(int[] arr)
    {
        return arr.length - new LIS().lis(arr);
    }

    public static void main(String[] args)
    {
        System.out.println(new MinDeletionsToMakeSortedSequence().minDeletions(new int[]{2, 3, 5, 1, 4, 7, 6}));
        System.out.println(new MinDeletionsToMakeSortedSequence().minDeletions(new int[]{2, 3, 5, 1, 4, 7}));
        System.out.println(new MinDeletionsToMakeSortedSequence().minDeletions(new int[]{2, 3, 9, 0, 4, 6}));
    }
}
