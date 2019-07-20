package 剑指offer;


/**
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并输出它的头节点。
 * <p>
 * 思路：我们知道在前序遍历中第一个出现的结点就是二叉树的根节点；在中序遍历中根节点出现在序列的中间，根节点左边是左子树，右边是右子树。
 * 左子树的根又可以用上面的方法得到，右子树的根又可以同样的方法得到。从此我们划分出左子树和右子树。根据递归的方法我们可以在二叉树的子树上不断调用此方法。
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode ( int x ) {
        val = x;
    }
}

public class No_6重建二叉树 {
    public TreeNode reConstructBinaryTree ( int[] pre, int[] in ) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode reConstructBinaryTree ( int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn ) {
        //第一步首先判断边界条件 -> 传参不合适
        if (startPre > endPre || startIn > endIn) return null;

        //新子树的根节点
        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++)
            //in[i] == pre[startPre] 意味着从中序排列中找到了二叉树的根节点，这个根节点左边是左子树，右边是右子树
            if (in[i] == pre[startPre]) {
                //找到根节点以后为根节点寻找左右子树，左子树连着的一个节点又是左子树的根节点。右子树连着的那个节点又是右子树的根节点。
                //这就引申成为了一个递归问题，每次将左右两个子树当成新的子树处理

                //新的endPre就是startPre加上子树的长度
                //startPre + i - startIn  这里这么取的原因：i-startIn左子树上结点的个数。i-startIn+startPre就是这一段都是左子树范围
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);

                //新的startPre就是上面那个+1
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        return root;

    }


}
