import java.util.LinkedList;

public class WordFrequencyPara {
    private final LinkedList<MyMapNode>[] hashArray;

    public WordFrequencyPara() {
        hashArray = new LinkedList[26];
        for (int i = 0; i < hashArray.length; i++) {
            hashArray[i] = new LinkedList<>();
        }
    }

    public void addWord(String word) {
        int index = getBucketIndex(word);
        LinkedList<MyMapNode> list = hashArray[index];

        MyMapNode node = findNode(list, word);
        if (node != null) {
            node.setValue(node.getValue() + 1);
        } else {
            node = new MyMapNode(word, 1);
            list.add(node);
        }
    }

    public void display() {
        for (int i = 0; i < hashArray.length; i++) {
            System.out.print(i + ":\t");
            LinkedList<MyMapNode> list = hashArray[i];
            for (int j = 0; j < list.size(); j++) {
                MyMapNode node = list.get(j);
                System.out.print(node.getKey() + ":" + node.getValue() + "\t");
            }
            System.out.println();
        }
    }

    private int getBucketIndex(String word) {
        return (int) (word.toLowerCase().charAt(0)) - 97;
    }

    private MyMapNode findNode(LinkedList<MyMapNode> list, String word) {
        for (int i = 0; i < list.size(); i++) {
            MyMapNode node = list.get(i);
            if (node.getKey().equals(word)) {
                return node;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String para = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
        String[] words = para.toLowerCase().split(" ");

        WordFrequencyPara wordFreq = new WordFrequencyPara();
        for (String word : words) {
            wordFreq.addWord(word);
        }

        wordFreq.display();
    }
}

class MyMapNode {
    private final String key;
    private int value;

    public MyMapNode(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
