package codes.java.stack;


import java.util.Stack;

public class NextGreaterElement {
    int[] nge(int[] arr)
    {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];

        for(int i = 0; i < n; i++)
        {
            while(!st.isEmpty() && arr[i] > arr[st.peek()])
                ans[st.pop()] = i;

            st.push(i);
        }
        while(!st.isEmpty())
            ans[st.pop()] = -1;
        return ans;
    }

    void printArray(int arr[])
    {
        for(int a: arr)
            System.out.print(a + " ");

        System.out.print("\n");
    }
    public static void main(String[] ar)
    {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6};
        int ans[] = new NextGreaterElement().nge(arr);
        new NextGreaterElement().printArray(ans);

        arr = new int[]{6, 5, 4, 3, 2, 1};
        ans = new NextGreaterElement().nge(arr);
        new NextGreaterElement().printArray(ans);

        arr = new int[]{10, 18, 15, 9, 7, 23};
        ans = new NextGreaterElement().nge(arr);
        new NextGreaterElement().printArray(ans);
    }
}
