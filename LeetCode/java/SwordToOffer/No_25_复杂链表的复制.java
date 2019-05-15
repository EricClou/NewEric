package SwordToOffer;


//输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
// 返回结果为复制后复杂链表的pHead。
// （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）


import java.util.HashMap;

/**
 * 思路1：
 * 可以使用map结构，key存储原结点，value存储新结点
 * <p>
 * 但是题目限定来输出结果不能返回参数中的节点引用，否则会返空，所以这个方法不适合
 */
public class No_25_复杂链表的复制 {


    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode ( int label ) {
            this.label = label;
        }
    }

    public RandomListNode Clone ( RandomListNode ppHead ) {

        if (ppHead == null) return null;
        HashMap <RandomListNode, RandomListNode> map = new HashMap <>();

        RandomListNode cur = ppHead;

        //把数值都复制完
        while (cur != null) {
            map.put(cur, new RandomListNode(ppHead.label));
            cur = cur.next;
        }


        //复制序列的头节点
        cur = ppHead;
        while (cur != null) {
            map.get(cur).next = cur.next;
            map.get(cur).random = cur.random;
            cur = cur.next;
        }

        return map.get(ppHead);
    }

    /**
     *
     * 这个方法是先现在每个节点的next后面差一个新的复制节点
     *
     * 再对原节点对random关系复制到新节点上面
     *
     * 最后把新节点和原节点剥离
     *
     * @param pHead
     * @return
     */

    public RandomListNode Clone2 ( RandomListNode pHead ) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cur = pHead;
        RandomListNode next = null;
        // copy node and link to every node
        while (cur != null) {
            next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }
        cur = pHead;
        RandomListNode curCopy = null;
        // set copy node rand
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }
        RandomListNode res = pHead.next;
        cur = pHead;
        // split
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }
}
