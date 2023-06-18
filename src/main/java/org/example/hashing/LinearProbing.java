package org.example.hashing;

import java.util.ArrayList;
import java.util.List;

public class LinearProbing {

    private static final double LOAD_FACTOR = 0.75;
    String[] hashTable;
    int usedCellNumber;

    public LinearProbing(int size) {
        hashTable = new String[size];
        usedCellNumber = 0;
    }

    public double getLoadFactor() {
        return usedCellNumber * 1.0 / hashTable.length;
    }

    public void display() {
        if (hashTable == null) {
            System.out.println("Not exist");
        } else {
            for (int i = 0; i < hashTable.length; i++) {
                System.out.println("Index: " + i + ", key: " + hashTable[i]);
            }
        }
    }

    public void insert(String word) {
        double loadFactor = getLoadFactor();
        if (loadFactor >= LOAD_FACTOR) {
            rehashKeys(word);
        } else {
            int index = modASCIIHashFunction(word, hashTable.length);
            for (int i = index; i < index + hashTable.length; i++) {
                int newIdx = i % hashTable.length;
                if (hashTable[newIdx] == null) {
                    hashTable[newIdx] = word;
                    break;
                }
            }
        }
        usedCellNumber++;
    }

    public boolean search(String word) {
        int index = modASCIIHashFunction(word, hashTable.length);
        for (int i = index; i < index + hashTable.length; i++) {
            int newIdx = i % hashTable.length;
            if (hashTable[newIdx] != null && hashTable[newIdx].equals(word)) {
                return true;
            }
        }
        return false;
    }

    public boolean delete(String word) {
        int index = modASCIIHashFunction(word, hashTable.length);
        for (int i = index; i < index + hashTable.length; i++) {
            int newIdx = i % hashTable.length;
            if (hashTable[newIdx] != null && hashTable[newIdx].equals(word)) {
                hashTable[newIdx] = null;
                return true;
            }
        }
        return false;
    }

    private void rehashKeys(String word) {
        usedCellNumber = 0;
        List<String> data = new ArrayList<>();
        for (String elem : hashTable) {
            if (elem != null) {
                data.add(elem);
            }
        }
        data.add(word);
        hashTable = new String[hashTable.length * 2];
        for (String elem : data) {
            insert(elem);
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
