package org.example.trie;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfString = true;
        System.out.println("Insertion was done successfully");
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                System.out.println("Word does not exist in a Trie");
                return false;
            }
            current = node;
        }
        //otherwise it is just a prefix
        if (current.endOfString) {
            System.out.println("Word exists");
            return true;
        } else {
            System.out.println("Word is a prefix of another string");
        }
        return current.endOfString;
    }

    public void delete(String word) {
        if (search(word)) {
            delete(root, word, 0);
        }
    }

    private boolean delete(TrieNode parent, String word, int index) {
        char ch = word.charAt(index);
        TrieNode current = parent.children.get(ch);
        boolean canBeDeleted;
        if (current.children.size() > 1) {
            delete(current, word, index + 1);
            return false;
        }
        if (index == word.length() - 1) {
            if (current.children.size() >= 1) {
                current.endOfString = false;
                return false;
            } else {
                parent.children.remove(ch);
                return true;
            }
        }
        if (current.endOfString) {
            delete(current, word, index + 1);
            return false;
        }

        canBeDeleted = delete(current, word, index + 1);
        if (canBeDeleted) {
            parent.children.remove(ch);
            return true;
        } else {
            return false;
        }
    }
}
