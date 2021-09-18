package codes.java.tree.trie;

import java.util.HashMap;

public class AddSearchWord {

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
    AddSearchWord()
    {
        root = new TrieNode();
    }

    void add(String word)
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
        return matchWord(word.toCharArray(), 0, root);
    }

    boolean matchWord(char[] word, int index, TrieNode currRoot)
    {
        if(index == word.length)
            return currRoot.isEnd;

        if(word[index] == '.')
        {
            for(char ch: currRoot.children.keySet())
                if(matchWord(word, index + 1, currRoot.children.get(ch)))
                    return true;
        }
        else
            return currRoot.children.containsKey(word[index]) && matchWord(word, index + 1, currRoot.children.get(word[index]));

        return false;
    }

    public static void main(String[] args)
    {
        AddSearchWord obj = new AddSearchWord();
        obj.add("bad");
        obj.add("dad");
        obj.add("mad");

        System.out.println(obj.search("pad"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.."));
    }

}
