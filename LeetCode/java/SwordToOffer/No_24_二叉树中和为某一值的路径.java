package SwordToOffer;


//输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
//路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
//(注意: 在返回值的list中，数组长度大的数组靠前)


import java.util.ArrayList;

public class No_24_二叉树中和为某一值的路径 {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode ( int val ) {
            this.val = val;

        }

    }

    public ArrayList <ArrayList <Integer>> listAll = new ArrayList <ArrayList <Integer>>();
    public ArrayList <Integer> list = new ArrayList <Integer>();

    public ArrayList <ArrayList <Integer>> FindPath ( TreeNode root, int target ) {

        //如果此二叉树为空，则直接返回结果
        if (root == null) return listAll;


        list.add(root.val);
        target -= root.val;

        //此路径走完且符合要求
        if (target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList <Integer>(list));


        //将子树的头节点当作参数
        FindPath(root.left, target);
        FindPath(root.right, target);


        //这里remove操作的意义是：移除最后一个元素，深度遍历完一条路径后要回退
        list.remove(list.size() - 1);

        return listAll;
    }
}
