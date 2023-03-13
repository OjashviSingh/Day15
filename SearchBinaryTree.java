public class SearchBinaryTree {
    Node root;

    public SearchBinaryTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }

    public boolean search(int data) {
        return searchRec(root, data);
    }

    boolean searchRec(Node root, int data) {
        if (root == null)
            return false;

        if (root.data == data)
            return true;

        if (root.data > data)
            return searchRec(root.left, data);

        return searchRec(root.right, data);
    }

    public static void main(String[] args) {
        SearchBinaryTree tree = new SearchBinaryTree();
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

        if (tree.search(63))
            System.out.println("63 found in the binary tree");
        else
            System.out.println("63 not found in the binary tree");
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }
}

