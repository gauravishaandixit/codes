package codes.java.tree.trie;

import java.util.HashMap;

public class ImplementPrefixTree {

    private static class TrieNode
    {
        HashMap<Character, TrieNode> children;
        boolean isEnd;

        TrieNode()
        {
            children = new HashMap<>();
            isEnd = false;
        }
    }

    private final TrieNode root;

    ImplementPrefixTree()
    {
        root = new TrieNode();
    }

    void insert(String word)
    {
        TrieNode curr = root;
        for(char ch: word.toCharArray())
        {
            curr.children.putIfAbsent(ch, new TrieNode());
            curr = curr.children.get(ch);
        }
        curr.isEnd = true;
    }

    boolean search(String word)
    {
        TrieNode curr = root;
        for(char ch: word.toCharArray())
        {
            if(curr.children.containsKey(ch))
                curr = curr.children.get(ch);
            else
                return false;
        }
        return curr.isEnd;
    }
    public static void main(String[] args)
    {
        ImplementPrefixTree obj = new ImplementPrefixTree();
        obj.insert("abc");
        obj.insert("def");
        obj.insert("ghi");
        System.out.println(obj.search("abc"));
        System.out.println(obj.search("abcd"));
        System.out.println(obj.search("ghi"));
    }
}
