package SwordToOffer;


//输入一个链表，输出该链表中倒数第k个结点。

import java.util.ArrayList;

public class No_14_链表中倒数第k个结点 {

    public static void main ( String[] args ) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println(new No_14_链表中倒数第k个结点().FindKthToTail(n1, 1).val);


    }

    public ListNode FindKthToTail ( ListNode head, int k ) {
        if (head == null||k<=0) return null;

        ArrayList <ListNode> res = new ArrayList <>();
        //用头插法确保倒叙
        while (head != null) {
            res.add(0, head);
            head = head.next;
        }

        if (k > res.size()) return null;

        return res.get(k - 1);
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode ( int val ) {
        this.val = val;
    }



}