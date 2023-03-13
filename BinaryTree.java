class Node {
    int data;
    SearchBinaryTree.Node left, right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    SearchBinaryTree.Node root;

    BinaryTree(int value) {
        root = new SearchBinaryTree.Node(value);
    }

    BinaryTree() {
        root = null;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    public SearchBinaryTree.Node insert(SearchBinaryTree.Node node, int data) {
        if (node == null) {
            node = new SearchBinaryTree.Node(data);
            return node;
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }

        return node;
    }

    public int size(SearchBinaryTree.Node node) {
        if (node == null) {
            return 0;
        } else {
            return (size(node.left) + 1 + size(node.right));
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(56);

        tree.insert(30);
        tree.insert(22);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(95);
        tree.insert(11);
        tree.insert(3);
        tree.insert(16);
        tree.insert(65);
        tree.insert(63);
        tree.insert(67);

        System.out.println("Binary Tree Size: " + tree.size(tree.root));
    }
}
