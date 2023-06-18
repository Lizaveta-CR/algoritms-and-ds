package org.example.binarytree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLL {
    BinaryNode<String> root;

    public BinaryTreeLL() {
        this.root = null;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        queue.push(root);
        int inorderIdx = 0;
        for (int i = 1; i < preorder.length; i++) {
            TreeNode prev = null;
            //stack's top element if equal then we need to isert to the right
            while (!queue.isEmpty() && queue.peek().val == inorder[inorderIdx]) {
                //last element
                prev = queue.pop();
                inorderIdx++;
            }

            TreeNode node = new TreeNode(preorder[i]);
            if (prev == null) {
                prev = queue.peek();
                prev.left = node;
            } else {
                prev.right = node;
            }

            queue.push(node);
        }
        return queue.poll();
    }

    void preOrderTraversal(BinaryNode node) {
        //reached the deepest leaf
        if (node == null) {
            return;
        }

        System.out.println(node.value + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    void inOrderTraversal(BinaryNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.value + " ");
        inOrderTraversal(root.right);
    }

    void postOrderTraversal(BinaryNode<String> root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
        System.out.println(root.value + " ");
    }

    void levelOrderTraversal() {
        Queue<BinaryNode<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode<String> presentNode = queue.remove();
            System.out.println(presentNode.value + " ");
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
    }

    void search(String value) {
        Queue<BinaryNode<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode<String> presentNode = queue.remove();
            if (presentNode.value.equals(value)) {
                System.out.println("Value is found in tree");
                return;
            }
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
        System.out.println("Value was not found");
    }

    void insert(String value) {
        BinaryNode<String> newNode = new BinaryNode<String>();
        newNode.value = value;
        if (root == null) {
            root = newNode;
            System.out.println("New node has been inserted");
            return;
        }

        Queue<BinaryNode<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode<String> presentNode = queue.remove();
            if (presentNode.left == null) {
                presentNode.left = newNode;
                break;
            }
            if (presentNode.right == null) {
                presentNode.right = newNode;
                break;
            }

            queue.add(presentNode.left);
            queue.add(presentNode.right);
        }
    }

    BinaryNode<String> getDeepest() {
        Queue<BinaryNode<String>> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode present = null;
        while (!queue.isEmpty()) {
            present = queue.remove();
            if (present.left != null) {
                queue.add(present.left);
            }
            if (present.right != null) {
                queue.add(present.right);
            }
        }
        return present;
    }

    void deleteDeepestNode() {
        Queue<BinaryNode<String>> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode current = null;
        BinaryNode previous = null;
        while (!queue.isEmpty()) {
            previous = current;
            current = queue.remove();
            //if current.left == null then right is the deepest
            if (current.left == null) {
                previous.right = null;
                return;
            }
            if (current.right == null) {
                current.left = null;
                return;
            }
            queue.add(current.left);
            queue.add(current.right);
        }
    }

    void deleteNode(String value) {
        Queue<BinaryNode<String>> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode<String> present = null;
        while (!queue.isEmpty()) {
            present = queue.remove();
            if (present.value.equals(value)) {
                present.value = getDeepest().value;
                deleteDeepestNode();
                System.out.println("Node was deleted");
                return;
            }
            if (present.left != null) {
                queue.add(present.left);
            }
            if (present.right != null) {
                queue.add(present.right);
            }
        }
        System.out.println("Node does not exist");
    }

    void deleteTree() {
        root = null;
    }

    //ot depth is the same
    int findHeight(BinaryNode<String> root) {
        if (root == null) {
            return 0;
        }
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        return Math.max(left, right) + 1;
    }
}
