package test.binarytree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BinarySearchTree {
    BinaryNode<Integer> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinaryNode<Integer> deleteNode(BinaryNode<Integer> root, int value) {
        if (root == null) {
            System.out.println("Value not found in BST");
            return null;
        }
        if (value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left != null && root.right != null) {
                BinaryNode<Integer> temp = root;
                BinaryNode<Integer> minNodeForRight = findSuccessor(temp.right);
                root.value = minNodeForRight.value;
                root.right = deleteNode(root.right, minNodeForRight.value);
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return root;
    }

    void insert(Integer val) {
        root = insert(root, val);
    }

    void preOrder(BinaryNode<Integer> root) {
        if (root == null) {
            return;
        }

        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    void inOrder(BinaryNode<Integer> root) {
        if (root == null) {
            return;
        }

        preOrder(root.left);
        System.out.print(root.value + " ");
        preOrder(root.right);
    }

    void postOrder(BinaryNode<Integer> root) {
        if (root == null) {
            return;
        }

        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.value + " ");
    }

    void levelOrder() {
        Queue<BinaryNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode<Integer> present = queue.remove();
            System.out.print(present.value + " ");
            if (present.left != null) {
                queue.add(present.left);
            }
            if (present.right != null) {
                queue.add(present.right);
            }
        }
    }

    void search(Integer value) {
        Queue<BinaryNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode<Integer> present = queue.remove();
            if (Objects.equals(value, present.value)) {
                System.out.println("Value was found");
                return;
            } else if (present.value >= value && present.left != null) {
                queue.add(present.left);
            } else if (present.value < value && present.right != null) {
                queue.add(present.right);
            }
        }
        System.out.println("404");
    }

    BinaryNode<Integer> search(BinaryNode<Integer> root, int value) {
        if (root == null) {
            System.out.println("404");
            return null;
        } else if (root.value == value) {
            System.out.println("Value was found");
            return root;
        } else if (value >= root.value) {
            return search(root.right, value);
        } else {
            return search(root.left, value);
        }
    }

    //to find minimum node
    BinaryNode<Integer> findSuccessor(BinaryNode<Integer> node) {
        if (node.left == null) {
            return node;
        }
        return findSuccessor(node.left);
    }

    private BinaryNode<Integer> insert(BinaryNode<Integer> current, Integer val) {
        if (current == null) {
            return new BinaryNode<>(val);
        } else if (current.value >= val) {
            current.left = insert(current.left, val);
        } else {
            current.right = insert(current.right, val);
        }
        return current;
    }
}
