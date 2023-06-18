package org.example.trie.custom;

import java.util.HashMap;
import java.util.Map;

public class Lettcode {
    public static void main(String[] args) {
        TrieCust obj = new TrieCust();
        obj.insert("app");
        obj.insert("apple");
        obj.insert("beer");
        obj.insert("add");
        obj.insert("add");
        obj.insert("jam");
        obj.insert("rental");
        System.out.println(obj.isSubstring(".app"));
    }
}

class TrieCust {
    TrieNodeCust root;

    public TrieCust() {
        root = new TrieNodeCust();
    }

    public void insert(String word) {
        TrieNodeCust current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNodeCust temp = root.children.get(ch);
            if (temp == null) {
                temp = new TrieNodeCust();
                current.children.put(ch, temp);
            }
            current = temp;
        }
        current.eof = true;
    }

    public boolean search(String word) {
        TrieNodeCust current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNodeCust temp = current.children.get(ch);
            if (temp == null) {
                return false;
            }
            current = temp;
        }
        return current.eof;
    }

    public boolean startsWith(String prefix) {
        TrieNodeCust current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            TrieNodeCust temp = current.children.get(ch);
            if (temp == null) {
                return false;
            }
            current = temp;
        }
        return true;
    }

    public boolean isSubstring(String word) {
        return search(word, root);
    }

    private boolean search(String word, TrieNodeCust base) {
        TrieNodeCust cur = base;
        char ch = word.charAt(0);
        TrieNodeCust node = cur.children.get(ch);
        if (ch == '.') {
            for (TrieNodeCust child : cur.children.values()) {
                return search(word.substring(1), child);
            }
        }
        if (node == null) {
            return false;
        }
        cur = node;
        return true;
    }
}

class TrieNodeCust {
    Map<Character, TrieNodeCust> children;
    boolean eof;

    TrieNodeCust() {
        children = new HashMap<>();
        eof = false;
    }

}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
