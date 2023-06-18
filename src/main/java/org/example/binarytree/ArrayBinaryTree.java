package org.example.binarytree;

public class ArrayBinaryTree {

    String[] arr;
    int lastUsedIndex;

    public ArrayBinaryTree(int size) {
        this.arr = new String[size + 1];
        this.lastUsedIndex = 0;
    }

    boolean isFull() {
        return arr.length == lastUsedIndex;
    }

    void insert(String value) {
        if (!isFull()) {
            arr[lastUsedIndex + 1] = value;
            lastUsedIndex++;
        }
    }

    void preOrderTraversal(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        System.out.print(arr[index] + " ");
        preOrderTraversal(index * 2);//leftChildren
        preOrderTraversal(index * 2 + 1);//rightChildren
    }

    void inOrderTraversal(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        preOrderTraversal(index * 2);
        System.out.print(arr[index] + " ");
        preOrderTraversal(index * 2 + 1);
    }

    void postOrderTraversal(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        preOrderTraversal(index * 2);
        preOrderTraversal(index * 2 + 1);
        System.out.print(arr[index] + " ");
    }

    void levelOrderTraversal() {
        for (int i = 1; i <= lastUsedIndex; i++) {
            System.out.println(arr[i]);
        }
    }

    int search(String value) {
        for (int i = 1; i <= lastUsedIndex; i++) {
            if (arr[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    void delete(String value) {
        int index = search(value);
        if (index != -1) {
            arr[index] = arr[lastUsedIndex];
            lastUsedIndex--;
        }
    }
}
