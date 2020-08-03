package codes.java.tree.trie;

import java.util.HashMap;

public class TrieNode {
    HashMap<Character, TrieNode> children;
    String word;

    TrieNode()
    {
        children = new HashMap<>();
        word = "";
    }
}
