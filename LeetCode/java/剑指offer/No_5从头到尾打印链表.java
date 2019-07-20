package 剑指offer;


import java.util.ArrayList;

/**
 * 题目：输入一个链表的头节点，从尾到头反过来打印出每个节点的值。
 * <p>
 * 思路：
 * 方法1：可以创建一个新的链表，遍历原链表的同时以头插法创建新的链表。
 * 方法2：用栈来遍历.
 * 方法3：递归写法，我们每次访问一个点的时候，先访问它后面，再访问它自身。但是这种写法在链表很长的时候容易导致栈溢出。
 */
class ListNode {
    int value;
    ListNode nextNode;
}


public class No_5从头到尾打印链表 {

    public static void main ( String[] args ) {
        ListNode root = new ListNode();
        ListNode n1 = new ListNode();
        ListNode n2 = new ListNode();
        ListNode n3 = new ListNode();
        ListNode n4 = new ListNode();
        root.nextNode = n1;
        n1.value = 1;
        n2.value = 2;
        n3.value = 3;
        n4.value = 4;
        n1.nextNode = n2;
        n2.nextNode = n3;
        n3.nextNode = n4;


        reverseListRecursively(root);

    }


    public static void reverseList ( ListNode head ) {
        ListNode headNode = new ListNode();
        headNode.nextNode = null;
        //拥有头节点。
        if (head == null && head.nextNode == null) return;

        while (head.nextNode != null) {
            ListNode newNode = new ListNode();
            newNode.value = head.nextNode.value;
            newNode.nextNode = headNode.nextNode;
            headNode.nextNode = newNode;

            head = head.nextNode;
        }

        while (headNode.nextNode != null) {
            System.out.println(headNode.nextNode.value);
            headNode = headNode.nextNode;
        }
    }

    public static void reverseListWithStack ( ListNode root ) {
        if (root == null && root.nextNode == null) return;
        ArrayList <ListNode> stack = new ArrayList();

        while (root.nextNode != null) {
            stack.add(0, root.nextNode);
            root = root.nextNode;
        }
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.get(i).value);
        }

    }

    public static void reverseListRecursively ( ListNode root ) {
        if (root == null && root.nextNode == null) return;
        if(root!=null){
            if(root.nextNode!=null){
                reverseListRecursively(root.nextNode);
            }
            System.out.println(root.value);
        }
    }


}
