package SwordToOffer;


//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
//如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。


/**
 * 二叉搜索树
 * <p>
 * 左孩子小，右孩子大
 * <p>
 * <p>
 * <p>
 * <p>
 * 已知条件：后序序列最后一个值为root；二叉搜索树左子树值都比root小，右子树值都比root大。
 * 1、确定root；
 * 2、遍历序列（除去root结点），找到第一个大于root的位置，则该位置左边为左子树，右边为右子树；
 * 3、遍历右子树，若发现有小于root的值，则直接返回false；
 * 4、分别判断左子树和右子树是否仍是二叉搜索树（即递归步骤1、2、3）。
 */
public class No_23_二叉搜索树的后序遍历 {


    public boolean VerifySquenceOfBST ( int[] sequence ) {
        if (sequence.length == 0)
            return false;
        if (sequence.length == 1)
            return true;
        return ju(sequence, 0, sequence.length - 1);

    }

    public boolean ju ( int[] a, int star, int root ) {
        if (star >= root)
            return true;
        int i = root;
        //从后面开始找
        while (i > star && a[i - 1] > a[root])
            i--;//找到比根小的坐标
        //从前面开始找 star到i-1应该比根小
        for (int j = star; j < i - 1; j++)
            if (a[j] > a[root])
                return false;
        return ju(a, star, i - 1) && ju(a, i, root - 1);
    }
}
