package 剑指offer;

/**
 * 题目：在一个排序链表中，如何删除重复的节点？
 * <p>
 * 思路：这里的删除重复节点是重复的几个节点全部删除
 */
public class No_19删除链表中的重复的节点 {
    static class ListNode {

        int value;
        ListNode next;

    }

    public static void main ( String[] args ) {
        ListNode p1 = new ListNode();
        ListNode p2 = new ListNode();
        ListNode p3 = new ListNode();
        ListNode p4 = new ListNode();
        ListNode p5 = new ListNode();

        p1.value = 1;
        p2.value = 2;
        p3.value = 3;
        p4.value = 3;
        p5.value = 4;

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = null;


        deleteDuplication2(p1);


        while (p1 != null) {
            System.out.print(p1.value + " ");
            p1 = p1.next;
        }

    }


    //重复的节点保留一个
    public static void deleteDuplication ( ListNode head ) {

        //链表为空或者链表只有一个节点
        if (head == null || head.next == null) return;


        //如果链表不止一个节点
        while (head.next != null) {

            //值重复了
            if (head.value == head.next.value) {
                //删除重复值
                head.next = head.next.next;
            }
            //往后走
            head = head.next;
        }

    }



    public static ListNode deleteDuplication2 ( ListNode head ) {
        ListNode first = new ListNode();//设置一个虚拟头节点

        first.next = head;

        //辅助节点
        ListNode p = head;

        //这个last是放在待删除节点前一个的位置上
        ListNode last = first;

        while (p != null && p.next != null) {
            if (p.value == p.next.value) {
                int val = p.value;

                //略过值重复的节点
                while (p != null && p.value == val) p = p.next;

                //删除
                last.next = p;
            } else {
                last = p;
                p = p.next;
            }
        }
        return first.next;

    }


}
