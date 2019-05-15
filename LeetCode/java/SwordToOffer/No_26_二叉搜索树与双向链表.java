package SwordToOffer;


//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
// 要求不能创建任何新的结点，只能调整树中结点指针的指向。

import java.util.ArrayList;

public class No_26_二叉搜索树与双向链表 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode ( int val ) {
            this.val = val;

        }
    }


    public TreeNode Convert ( TreeNode pRootOfTree ) {
        if (pRootOfTree == null) return null;
        if (pRootOfTree.left == null && pRootOfTree.right == null) return pRootOfTree;
        ArrayList <TreeNode> list = new ArrayList <>();
        LDR(pRootOfTree, list);

        list.get(0).left = null;
        list.get(0).right = list.get(1);
        list.get(list.size() - 1).left = list.get(list.size() - 2);
        list.get(list.size() - 1).right = null;
        for (int i = 1; i < list.size() - 1; i++) {
            list.get(i).left = list.get(i - 1);
            list.get(i).right = list.get(i + 1);
        }
        return list.get(0);

    }


    //中序遍历
    public void LDR ( TreeNode root, ArrayList <TreeNode> firstList ) {
        if (root == null) return;
        LDR(root.left, firstList);
        if (root != null) firstList.add(root);
        LDR(root.right, firstList);

    }


}
