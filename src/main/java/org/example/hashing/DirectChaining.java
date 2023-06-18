package org.example.hashing;

import java.util.LinkedList;

public class DirectChaining {

    LinkedList<String>[] hashTable;
    int maxChainSize = 5;

    public DirectChaining(int size) {
        hashTable = new LinkedList[size];
    }

    public void insert(String word) {
        int index = modASCIIHashFunction(word, hashTable.length);
        if (hashTable[index] == null) {
            hashTable[index] = new LinkedList<>();
        }
        hashTable[index].add(word);
    }

    public boolean search(String word) {
        int index = modASCIIHashFunction(word, hashTable.length);
        boolean exists = true;
        if (hashTable[index] == null) {
            exists = false;
        } else {
            exists = hashTable[index].contains(word);
        }
        return exists;
    }

    public boolean delete(String word){
        int index = modASCIIHashFunction(word, hashTable.length);
        boolean deleted = true;
        if (hashTable[index] == null) {
            deleted = false;
        } else {
            deleted = hashTable[index].remove(word);
        }
        return deleted;
    }
    public void display() {
        if (hashTable == null) {
            System.out.println("Not exist");
        } else {
            for (int i = 0; i < hashTable.length; i++) {
                System.out.println("Index + " + i + ", key" + hashTable[i]);
            }
        }
    }

    private int modASCIIHashFunction(String word, int numOfCells) {
        char[] chars = word.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            sum += chars[i];
        }
        return sum % numOfCells;
    }
}
