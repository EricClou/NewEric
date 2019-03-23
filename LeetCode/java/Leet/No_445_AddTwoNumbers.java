package Leet;


import java.util.Stack;

public class No_445_AddTwoNumbers {


    public  class ListNode {
        int val;
        ListNode next;

        ListNode ( int x ) {
            val = x;
        }
    }

    public ListNode addTwoNumbers ( ListNode l1, ListNode l2 ) {
        Stack <ListNode> temp1 = new Stack <>();
        Stack <ListNode> temp2 = new Stack <>();
        Stack <ListNode> res = new Stack <>();
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int carry = 0;  //判断是否会进位
        while (l1 != null) {
            temp1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            temp2.push(l2);
            l2 = l2.next;
        }

        while (!temp1.isEmpty() || !temp2.isEmpty()) {
            int x = (!temp1.isEmpty()) ? temp1.pop().val : 0;
            int y = (!temp2.isEmpty()) ? temp2.pop().val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            res.push(new ListNode(sum % 10));
        }
        if (carry > 0) {
            res.push(new ListNode(carry));

        }
        while (!res.isEmpty()) {
            cur.next = res.pop();
            cur = cur.next;
        }
        return dummyHead.next;
    }

}
