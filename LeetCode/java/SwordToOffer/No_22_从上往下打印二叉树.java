package SwordToOffer;


//从上往下打印出二叉树的每个节点，同层节点从左至右打印。

import java.util.ArrayList;


/**
 * 这就是二叉树的广度遍历啊
 * <p>
 * 思路：借助一个队列实现这个任务
 */
public class No_22_从上往下打印二叉树 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode ( int val ) {
            this.val = val;

        }
    }

    public ArrayList <Integer> PrintFromTopToBottom ( TreeNode root ) {
        ArrayList <TreeNode> temp = new ArrayList <>();
        ArrayList <Integer> res = new ArrayList <>();
        TreeNode help = null;

        if (root == null) return res;

        if (root != null) temp.add(root);
        while (!temp.isEmpty()) {
            help = temp.remove(0);
            if (help.left != null) temp.add(help.left);
            if (help.right != null) temp.add(help.right);
            res.add(help.val);
        }
        return res;
    }
}
