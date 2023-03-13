public class BinarySearchTree<K extends Comparable<K>> {
    private INode<K> root;

    public void add(K key) {
        this.root = addRecursively(root, key);
    }

    private INode<K> addRecursively(INode<K> current, K key) {
        if (current == null) {
            return new MyBinaryNode<>(key);
        }

        if (key.compareTo(current.getKey()) < 0) {
            current.setLeft(addRecursively(current.getLeft(), key));
        } else if (key.compareTo(current.getKey()) > 0) {
            current.setRight(addRecursively(current.getRight(), key));
        }

        return current;
    }

    public int size() {
        return getSizeRecursively(root);
    }

    private int getSizeRecursively(INode<K> current) {
        return current == null ? 0 : 1 + getSizeRecursively(current.getLeft()) + getSizeRecursively(current.getRight());
    }
}

interface INode<K> {
    K getKey();

    void setKey(K key);

    INode<K> getLeft();

    void setLeft(INode<K> left);

    INode<K> getRight();

    void setRight(INode<K> right);
}

class MyBinaryNode<K extends Comparable<K>> implements INode<K> {
    private K key;
    private INode<K> left;
    private INode<K> right;

    public MyBinaryNode(K key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public INode<K> getLeft() {
        return left;
    }

    @Override
    public void setLeft(INode<K> left) {
        this.left = left;
    }

    @Override
    public INode<K> getRight() {
        return right;
    }

    @Override
    public void setRight(INode<K> right) {
        this.right = right;
    }
}
