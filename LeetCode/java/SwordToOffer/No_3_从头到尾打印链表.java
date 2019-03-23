package SwordToOffer;

//输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。

import java.util.ArrayList;


public class No_3_从头到尾打印链表 {
    public ArrayList <Integer> printListFromTailToHead ( ListNode listNode ) {
        ArrayList <Integer> ans = new ArrayList <>();
        while (listNode != null) {
            ans.add(0, listNode.val);
            listNode = listNode.next;

        }
        return ans;
    }

    public static void main ( String[] args ) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        System.out.println(new No_3_从头到尾打印链表().printListFromTailToHead(a));
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode ( int val ) {
            this.val = val;
        }
    }

}
