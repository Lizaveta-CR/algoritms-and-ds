package org.example.hashing;

import java.util.ArrayList;
import java.util.List;

public class DoubleHashing {

    private static final double LOAD_FACTOR = 0.75;
    String[] hashTable;
    int usedCellNumber;

    public DoubleHashing(int size) {
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

    public void insert(String elem) {
        if (getLoadFactor() > LOAD_FACTOR) {
            rehashKeys(elem);
        } else {
            int modIndex = modASCIIHashFunction(elem, hashTable.length);
            int secIndex = secHashFunction(elem, hashTable.length);
            for (int i = 0; i < hashTable.length; i++) {
                int newIdx = (modIndex + i * secIndex) % hashTable.length;
                if (hashTable[newIdx] == null) {
                    hashTable[newIdx] = elem;
                    break;
                }
            }
        }
        usedCellNumber++;
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

    private int secHashFunction(String x, int numOfCells) {
        char[] chars = x.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            sum += chars[i];
        }
        while (sum > numOfCells) {
            sum = addAllDigitsTogether(sum);
        }

        return sum % numOfCells;
    }

    private int addAllDigitsTogether(int sum) {
        int val = 0;
        while (sum > 0) {
            val += sum % 10;
            sum /= 10;
        }
        return val;
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
