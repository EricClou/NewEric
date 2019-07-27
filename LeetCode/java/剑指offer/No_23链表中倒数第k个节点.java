package 剑指offer;

/**
 * 题目：输入一个链表，输出该链表中倒数第k个节点。
 * <p>
 * 思路：
 * 只遍历一边遍就找到倒数第k个节点。
 * 定义两个指针，第一个指针从链表第头指针开始遍历向前走k-1步，第二个指针保持不动；
 * 从第k步开始，第二个指针开始从链表第头指针开始遍历。
 * 由于两个指针的距离保持在k-1，所以当第一个指针走到链表的尾节点的时候，
 * 第二个指针正好走到（n-k+1）的位置上，也就正好是倒数第k个节点
 * <p>
 * 注意：要注意一点————当k大于整体链表个数的情况
 * <p>
 * 提示：当我们用一个指针遍历链表不能解决问题的时候，可以尝试用两个指针来遍历链表。
 * 可以让其中一个指针遍历的速度快一些，或者先让它在链表上走若干步（快慢指针）
 */
public class No_23链表中倒数第k个节点 {

    public static void main ( String[] args ) {
        ListNode p1 = new ListNode();
        ListNode p2 = new ListNode();
        ListNode p3 = new ListNode();
        ListNode p4 = new ListNode();
        ListNode p5 = new ListNode();

        p1.value = 1;
        p2.value = 2;
        p3.value = 3;
        p4.value = 4;
        p5.value = 5;

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = null;
        System.out.println(printResverK(p1, 6).value);
    }

    static class ListNode {
        int value;
        ListNode next;
    }

    public static ListNode printResverK ( ListNode head, int k ) {
        if (head == null || k < 1) return null;

        ListNode first = null;
        ListNode second = null;
        first = head;
        second = head;

        int count = 0;

        while (first.next != null) {
            if (count < k - 1) {
                count++;
                first = first.next;
                if (first.next == null && k > count) return null;

            } else {


                //直到第一个指针走到头为止，两个一起走
                first = first.next;
                second = second.next;
            }
        }
        //第一个指针走到头
        return second;


    }

}
