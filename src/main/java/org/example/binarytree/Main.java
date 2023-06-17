package test.binarytree;

public class Main {

    public static void main(String[] args) {
        BinaryTreeLL binaryTreeLL = new BinaryTreeLL();
        binaryTreeLL.insert("N1");
        binaryTreeLL.insert("N2");
        binaryTreeLL.insert("N3");
        binaryTreeLL.insert("N4");
        binaryTreeLL.insert("N5");
        binaryTreeLL.insert("N6");
        binaryTreeLL.levelOrderTraversal();
        System.out.println(binaryTreeLL.findHeight(binaryTreeLL.root));
        binaryTreeLL.deleteNode("N3");
        System.out.println();
        binaryTreeLL.levelOrderTraversal();

        binaryTreeLL.buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7});
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(6);
        arrayBinaryTree.insert("N1");
        arrayBinaryTree.insert("N2");
        arrayBinaryTree.insert("N3");
        arrayBinaryTree.insert("N4");
        arrayBinaryTree.insert("N5");
        arrayBinaryTree.insert("N6");
        arrayBinaryTree.preOrderTraversal(1);
        System.out.println();
        arrayBinaryTree.delete("N4");
        arrayBinaryTree.levelOrderTraversal();

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(70);
        binarySearchTree.insert(50);
        binarySearchTree.insert(90);
        binarySearchTree.insert(30);
        binarySearchTree.insert(60);
        binarySearchTree.insert(80);
        binarySearchTree.insert(100);
        binarySearchTree.insert(20);
        binarySearchTree.insert(40);
        binarySearchTree.preOrder(binarySearchTree.root);
        System.out.println();
        binarySearchTree.inOrder(binarySearchTree.root);
        System.out.println();
        binarySearchTree.postOrder(binarySearchTree.root);
        System.out.println();
        binarySearchTree.levelOrder();
        System.out.println();
        binarySearchTree.search(11);
        binarySearchTree.search(binarySearchTree.root, 40);
        binarySearchTree.deleteNode(binarySearchTree.root, 40);
        binarySearchTree.levelOrder();
        System.out.println();

    }
}
