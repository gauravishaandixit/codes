package codes.java.queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingChar {

    String firstNonRepeating(String str)
    {
        StringBuilder ans = new StringBuilder();
        Queue<Character> q = new LinkedList();
        char[] map = new char[26];

        for(var ch: str.toCharArray())
        {
            map[ch - 'a']++;
            q.add(ch);
            if(map[ch - 'a'] == 1)
                ans.append(q.peek());
            else
            {
                while(!q.isEmpty())
                {
                    if(map[q.peek() - 'a'] != 1)
                        q.poll();
                    else
                        break;
                }

                if(q.isEmpty())
                    ans.append('#');
                else
                    ans.append(q.peek());
            }
        }
        return ans.toString();
    }

    public static void main(String[] ar)
    {
        System.out.println(new FirstNonRepeatingChar().firstNonRepeating("abadbc"));
        System.out.println(new FirstNonRepeatingChar().firstNonRepeating("abcabc"));
    }
}
