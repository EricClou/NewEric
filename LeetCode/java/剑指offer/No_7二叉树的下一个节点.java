package 剑指offer;

/**
 * 题目：给定一棵二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？树中的节点除了有两个分别指向左右
 * 子节点的指针，还有一个指向父节点的指针。
 * <p>
 * 思路：这种情形要分情况讨论：
 * 1、如果一个节点有右子树，那么右子树的下一个节点就是它的右子树的最左子节点(一直沿着左子节点直到走到空)。
 * 2、如果一个节点没有右子树，且此节点是其父节点的左子节点。那么它的下一个节点就是它的父节点。
 * 3、如果一个节点既没有右子树，并且它还是它父节点的右子节点。那么可以沿着父节点的指针一路向上遍历，
 * 直到找到一个是它父节点的左子节点的节点。如果其存在，那么它就是下一个节点。
 * 按照上面的三种情况写。
 */


class BinaryTreeNode {
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode parent;

    BinaryTreeNode ( int value ) {
        this.value = value;
    }
}

public class No_7二叉树的下一个节点 {

    public static void main ( String[] args ) {
        BinaryTreeNode n1 = new BinaryTreeNode(7);
        BinaryTreeNode n2 = new BinaryTreeNode(4);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(6);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(1);
        BinaryTreeNode n7 = new BinaryTreeNode(9);
        BinaryTreeNode n8 = new BinaryTreeNode(8);
        n1.left = n2;
        n2.parent = n1;
        n2.left = n3;
        n3.parent = n2;
        n2.right = n4;
        n4.parent = n2;
        n1.right = n5;
        n5.parent = n1;
        n5.left = n6;
        n6.parent = n5;
        n6.left = n7;
        n7.parent = n6;
        n5.right = n8;
        n8.parent = n5;

        System.out.println(findNextNode(n4).value);


    }

    public static BinaryTreeNode findNextNode ( BinaryTreeNode node ) {
        if (node == null) return null;
        if (node.right != null) {
            BinaryTreeNode temp = null;
            temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }

        if (node.right == null && node.parent.left == node) return node.parent;

        if (node.right == null && node.parent.right == node) {
            BinaryTreeNode temp = null;
            temp = node.parent;
            while (temp.parent != null) {
                if (temp.parent.left == temp) return temp;
                else temp = temp.parent;
            }
        }
        return null;

    }
}
