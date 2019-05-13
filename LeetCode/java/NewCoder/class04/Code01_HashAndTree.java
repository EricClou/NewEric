package NewCoder.class04;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Code01_HashAndTree {

    public static class Node {
        public int value;
        public Node next;

        public Node ( int val ) {
            value = val;
        }
    }

    /**
     * 在java结构中，有序表是一种逻辑概念，在物理上我们实现有序表有多种多样的方式。
     * 而我们在创建有序表的过程中，通常遵循key1>key2，则value1>value2这种方式或者key1>key2，则value1<value2这种方式
     * <p>
     * 有序表红黑树、AVL树、size-balance-tree和跳表等都属于有序表结构，只是底层具体实现不同
     * 在java中如果key是常数值那么它们可以直接比较（包括包装类），但是如果是对象则必须要写出比较器
     */

    //这个比较器的排序标准是key1>key2，则value1>value24
    public static class NodeComparator implements Comparator <Node> {

        @Override
        public int compare ( Node o1, Node o2 ) {
            return o1.value - o2.value;
        }

    }

    public static void main ( String[] args ) {
        Node nodeA = null;
        Node nodeB = null;
        Node nodeC = null;

        // hashSet1的key是基础类型->int类型
        HashSet <Integer> hashSet1 = new HashSet <>();
        hashSet1.add(3);
        System.out.println(hashSet1.contains(3));
        hashSet1.remove(3);
        System.out.println(hashSet1.contains(3));
        System.out.println("========1=========");

        // hashSet2的key是非基础类型->Node类型
        /**
         * 非基础类型在放入哈希表的时候，即使保存的数值相同，但其是按对象的索引地址存储的
         * 而基础类型是值传递，也就是说相同的key，不同的value，在存储的时候最近存储的那个会更新表中的值
         */
        nodeA = new Node(1);
        nodeB = new Node(1);
        HashSet <Node> hashSet2 = new HashSet <>();
        hashSet2.add(nodeA);
        System.out.println(hashSet2.contains(nodeA));
        System.out.println(hashSet2.contains(nodeB));
        hashSet2.remove(nodeA);
        System.out.println(hashSet2.contains(nodeA));
        System.out.println("========2=========");

        // hashMap1的key是基础类型->String类型
        HashMap <String, Integer> hashMap1 = new HashMap <>();
        String str1 = "key";
        String str2 = "key";
        hashMap1.put(str1, 1);
        System.out.println(hashMap1.containsKey(str1));
        System.out.println(hashMap1.containsKey(str2));
        System.out.println(hashMap1.get(str1));
        System.out.println(hashMap1.get(str2));

        hashMap1.put(str2, 2);
        System.out.println(hashMap1.containsKey(str1));
        System.out.println(hashMap1.containsKey(str2));
        System.out.println(hashMap1.get(str1));
        System.out.println(hashMap1.get(str2));

        hashMap1.remove(str1);
        System.out.println(hashMap1.containsKey(str1));
        System.out.println(hashMap1.containsKey(str2));
        System.out.println("========3=========");

        // hashMap2的key是非基础类型->Node类型
        nodeA = new Node(1);
        nodeB = new Node(1);
        HashMap <Node, String> hashMap2 = new HashMap <>();
        hashMap2.put(nodeA, "A节点");
        System.out.println(hashMap2.containsKey(nodeA));
        System.out.println(hashMap2.containsKey(nodeB));
        System.out.println(hashMap2.get(nodeA));
        System.out.println(hashMap2.get(nodeB));
        hashMap2.put(nodeB, "B节点");
        System.out.println(hashMap2.containsKey(nodeA));
        System.out.println(hashMap2.containsKey(nodeB));
        System.out.println(hashMap2.get(nodeA));
        System.out.println(hashMap2.get(nodeB));
        System.out.println("========4=========");

        // treeSet的key是非基础类型->Node类型
        nodeA = new Node(5);
        nodeB = new Node(3);
        nodeC = new Node(7);

        TreeSet <Node> treeSet = new TreeSet <>();
        // 以下的代码会报错，因为没有提供Node类型的比较器
        try {
            treeSet.add(nodeA);
            treeSet.add(nodeB);
            treeSet.add(nodeC);
        } catch (Exception e) {
            System.out.println("错误信息：" + e.getMessage());
        }

        treeSet = new TreeSet <>(new NodeComparator());
        // 以下的代码没问题，因为提供了Node类型的比较器
        try {
            treeSet.add(nodeA);
            treeSet.add(nodeB);
            treeSet.add(nodeC);
            System.out.println("这次节点都加入了");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("========5=========");

        // 展示有序表常用操作
        TreeMap <Integer, String> treeMap1 = new TreeMap <>();
        treeMap1.put(7, "我是7");
        treeMap1.put(5, "我是5");
        treeMap1.put(4, "我是4");
        treeMap1.put(3, "我是3");
        treeMap1.put(9, "我是9");
        treeMap1.put(2, "我是2");
        System.out.println(treeMap1.containsKey(5));
        System.out.println(treeMap1.get(5));
        System.out.println(treeMap1.firstKey() + ", 我最小");
        System.out.println(treeMap1.lastKey() + ", 我最大");
        System.out.println(treeMap1.floorKey(8) + ", 在表中所有<=8的数中，我离8最近");
        System.out.println(treeMap1.ceilingKey(8) + ", 在表中所有>=8的数中，我离8最近");
        System.out.println(treeMap1.floorKey(7) + ", 在表中所有<=7的数中，我离7最近");
        System.out.println(treeMap1.ceilingKey(7) + ", 在表中所有>=7的数中，我离7最近");
        treeMap1.remove(5);
        System.out.println(treeMap1.get(5) + ", 删了就没有了哦");
        System.out.println("========6=========");

    }

}
