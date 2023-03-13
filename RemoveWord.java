import java.util.*;

public class RemoveWord {

    public static void main(String[] args) {
        String phrase = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";

        List<MapNode<String, Integer>> hashTable = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            hashTable.add(null);
        }

        String[] words = phrase.toLowerCase().split(" ");
        for (String word : words) {
            int index = Math.abs(word.hashCode()) % 10;
            MapNode<String, Integer> newNode = new MapNode<>(word, 1);

            if (hashTable.get(index) == null) {
                hashTable.set(index, newNode);
            } else {
                MapNode<String, Integer> currentNode = hashTable.get(index);
                while (currentNode.getNext() != null) {
                    if (currentNode.getKey().equals(word)) {
                        currentNode.setValue(currentNode.getValue() + 1);
                        break;
                    }
                    currentNode = currentNode.getNext();
                }
                if (currentNode.getKey().equals(word)) {
                    currentNode.setValue(currentNode.getValue() + 1);
                } else {
                    currentNode.setNext(newNode);
                }
            }
        }

        int indexToRemove = Math.abs("avoidable".hashCode()) % 10;
        MapNode<String, Integer> currentNode = hashTable.get(indexToRemove);
        if (currentNode != null && currentNode.getKey().equals("avoidable")) {
            hashTable.set(indexToRemove, currentNode.getNext());
        } else {
            while (currentNode != null && currentNode.getNext() != null) {
                if (currentNode.getNext().getKey().equals("avoidable")) {
                    currentNode.setNext(currentNode.getNext().getNext());
                    break;
                }
                currentNode = currentNode.getNext();
            }
        }

        for (int i = 0; i < 10; i++) {
            MapNode<String, Integer> currentNode2 = hashTable.get(i);
            while (currentNode2 != null) {
                System.out.println(currentNode2.getKey() + ": " + currentNode2.getValue());
                currentNode2 = currentNode2.getNext();
            }
        }
    }
}

class MapNode<K, V> {
    private K key;
    private V value;
    private MapNode<K, V> next;

    public MapNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public MapNode<K, V> getNext() {
        return next;
    }

    public void setNext(MapNode<K, V> next) {
        this.next = next;
    }
}
