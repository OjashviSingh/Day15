import java.util.LinkedList;

public class WordFrequency {

    public static void main(String[] args) {
        String sentence = "To be or not to be";
        String[] words = sentence.split(" ");

        MyHashTable hashTable = new MyHashTable();

        for (String word : words) {
            hashTable.add(word.toLowerCase());
        }

        hashTable.display();
    }

    static class MyMapNode {
        String key;
        int value;

        public MyMapNode(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    static class MyHashTable {
        private LinkedList<MyMapNode>[] buckets;
        private int numBuckets;
        private int size;

        public MyHashTable() {
            numBuckets = 10;
            size = 0;
            buckets = new LinkedList[numBuckets];

            for (int i = 0; i < numBuckets; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int getBucketIndex(String key) {
            int hash = key.hashCode();
            int index = hash % numBuckets;
            return index;
        }

        public void add(String key) {
            int bucketIndex = getBucketIndex(key);
            LinkedList<MyMapNode> bucket = buckets[bucketIndex];
            MyMapNode node = find(bucket, key);

            if (node == null) {
                bucket.add(new MyMapNode(key, 1));
                size++;
            } else {
                node.setValue(node.getValue() + 1);
            }
        }

        public void display() {
            for (int i = 0; i < numBuckets; i++) {
                System.out.print("Bucket " + i + ": ");
                LinkedList<MyMapNode> bucket = buckets[i];

                for (MyMapNode node : bucket) {
                    System.out.print(node.getKey() + "=>" + node.getValue() + " ");
                }

                System.out.println();
            }
        }

        private MyMapNode find(LinkedList<MyMapNode> bucket, String key) {
            for (MyMapNode node : bucket) {
                if (node.getKey().equals(key)) {
                    return node;
                }
            }

            return null;
        }
    }
}
