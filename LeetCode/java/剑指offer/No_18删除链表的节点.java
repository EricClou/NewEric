package 剑指offer;


/**
 * 题目：在O(1)时间内删除链表节点。给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点。
 * <p>
 * 思路：可以选择把下一个节点的内容复制到当前需要删除的节点上覆盖原有的内容，再把下一个节点删除。
 * 这题的着重点在于要把各个情况考虑清楚。
 */
public class No_18删除链表的节点 {
    class ListNode {

        int value;
        ListNode next;

    }

    public static void deleteNode ( ListNode head, ListNode p ) {
        if (head == null || p == null) return;


        //只有头节点这一个节点
        if (head == p && head.next == null) head = null;


        //如果是多个节点的链表，p是尾节点
        if (p.next == null&&head!=p) {p=null;
        }


        //p不是尾节点
        if(p.next!=null) {
            p.value = p.next.value;
            p.next = p.next.next;
        }


    }


}
