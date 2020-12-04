package codes.java.stack;

import java.util.Stack;

public class RemoveDuplicatesString {

    String removeDuplicates(String str)
    {
        Stack<Character> st = new Stack<>();
        for(char ch: str.toCharArray())
        {
            if(!st.isEmpty() && st.peek().equals(ch))
                st.pop();
            else
                st.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
            sb.append(st.pop());
        return sb.reverse().toString();
    }

    public static void main(String[] ar)
    {
        System.out.println(new RemoveDuplicatesString().removeDuplicates("aaabbcdd"));
    }
}
