package test.binarytree;

public class BinaryNode<T> {
    T value;
    BinaryNode left;
    BinaryNode right;

    public BinaryNode() {
    }

    public BinaryNode(T value) {
        this.value = value;
    }
}
