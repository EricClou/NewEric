package SwordToOffer;

//操作给定的二叉树，将其变换为源二叉树的镜像。

//
//二叉树的镜像定义：源二叉树
//        8
//        /  \
//        6   10
//        / \  / \
//        5  7 9 11

//        镜像二叉树
//        8
//        /  \
//        10   6
//        / \  / \
//        11 9 7  5


public class No_18_二叉树的镜像 {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode ( int val ) {
            this.val = val;
        }
    }


    /**
     * 思路1：已经知道了二叉树的层序遍历，如果我们在层序遍历的时候改变左右子节点的插入顺序，则刚好得到镜像的顺序
     *
     * @param root
     */


    public void Mirror ( TreeNode root ) {
        TreeNode tmp = null;
        if (root != null) {

            //这一句就是简单的交换啊
            tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            if (root.left != null)
                Mirror(root.left);
            if (root.right != null)
                Mirror(root.right);
        }
    }
}







