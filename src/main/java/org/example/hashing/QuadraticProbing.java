package org.example.hashing;

import java.util.ArrayList;
import java.util.List;

public class QuadraticProbing {

    private static final double LOAD_FACTOR = 0.75;
    String[] hashTable;
    int usedCellNumber;

    public QuadraticProbing(int size) {
        hashTable = new String[size];
        usedCellNumber = 0;
    }

    public double getLoadFactor() {
        return usedCellNumber * 1.0 / hashTable.length;
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

    public void display() {
        if (hashTable == null) {
            System.out.println("Not exist");
        } else {
            for (int i = 0; i < hashTable.length; i++) {
                System.out.println("Index: " + i + ", key: " + hashTable[i]);
            }
        }
    }

    public void insert(String elem) {
        if (getLoadFactor() >= LOAD_FACTOR) {
            rehashKeys(elem);
        } else {
            int index = modASCIIHashFunction(elem, hashTable.length);
            int quadratic = 0;
            for (int i = 0; i < index + hashTable.length; i++) {
                int newInd = (index + (quadratic * quadratic)) % hashTable.length;
                if (hashTable[newInd] == null) {
                    hashTable[newInd] = elem;
                    break;
                }
                quadratic++;
            }
        }
        usedCellNumber++;
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
