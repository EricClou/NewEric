package SwordToOffer;

//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
public class No_16_合并两个排序的链表 {
    public static void main ( String[] args ) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n3;
        n2.next = n4;
        n3.next = n5;

        System.out.println(new No_16_合并两个排序的链表().Merge(n1, n2).next.val);

    }

    public ListNode Merge ( ListNode list1, ListNode list2 ) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1 == null && list2 == null) return null;
        ListNode pre =  new ListNode(0);
        ListNode head =null;
        head = pre;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                pre.next = list2;
                pre = pre.next;
                list2 = list2.next;
            } else {
                pre.next = list1;
                pre = pre.next;
                list1 = list1.next;

            }
            if (list1 == null && list2 != null) {
                pre.next = list2;
            }
            if (list2 == null && list1 != null) {
                pre.next = list1;
            }
        }
        return head.next;

    }

}
