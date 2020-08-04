package codes.java.arrays;

public class AddOne {

    int[] addOne(int[] arr)
    {
        for(int i = arr.length - 1; i >= 0; i--)
        {
            if(arr[i]< 9)
            {
                arr[i] ++;
                return arr;
            }
            arr[i] = 0;
        }

        int[] ans = new int[arr.length + 1];
        ans[0] = 1;
        return ans;
    }

    static void printArray(int[] nums)
    {
        for(int num: nums)
            System.out.print(num + " ");

        System.out.print("\n");
    }

    public static void main(String[] args)
    {
        int[] ans = new AddOne().addOne(new int[]{1, 2, 3, 4, 5});
        printArray(ans);

        ans = new AddOne().addOne(new int[]{1, 2, 9, 9, 9});
        printArray(ans);

        ans = new AddOne().addOne(new int[]{9, 9, 9, 9, 9});
        printArray(ans);
    }
}
