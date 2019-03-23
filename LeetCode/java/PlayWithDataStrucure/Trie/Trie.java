package PlayWithDataStrucure.Trie;

import java.util.TreeMap;

/**
 * Trie就像是字典一样
 * 比如我们在查一个单词的时候，用contains为例
 * 第一个节点是c,子节点o，孙子节点n，自动往后排
 */
/// 使用TreeMap的Trie
public class Trie {

    private class Node {

        public boolean isWord;
        public TreeMap <Character, Node> next;

        public Node ( boolean isWord ) {
            this.isWord = isWord;
            next = new TreeMap <>();
        }

        public Node () {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie () {
        root = new Node();
        size = 0;
    }

    // 获得Trie中存储的单词数量
    public int getSize () {
        return size;
    }

    // 向Trie中添加一个新的单词word
    public void add ( String word ) {

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }

        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    // 查询单词word是否在Trie中
    public boolean contains ( String word ) {

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }
}
