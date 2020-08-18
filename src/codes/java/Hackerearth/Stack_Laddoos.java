package codes.java.Hackerearth;

import java.util.HashMap;
import java.util.Stack;

public class Stack_Laddoos {

    void laddoos(int[] arr)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a: arr)
            map.put(a, map.getOrDefault(a, 0) + 1);


        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < arr.length; i++)
        {
            while(!st.isEmpty() && map.get(arr[i]) > map.get(arr[st.peek()]))
                arr[st.pop()] = arr[i];
            st.push(i);
        }

        while(!st.isEmpty())
            arr[st.pop()] = -1;

        StringBuilder sb = new StringBuilder();
        for(int a: arr)
            sb.append(a + " ");

        System.out.println(sb.toString().trim());
    }

    public static void main(String[] ar)
    {
        new Stack_Laddoos().laddoos(new int[]{1, 3, 7, 2, 5, 1, 4, 2, 1, 5});
        new Stack_Laddoos().laddoos(new int[]{1, 1, 1, 1, 1});
        new Stack_Laddoos().laddoos(new int[]{1, 1, 2, 2, 2, 3});
    }
}
