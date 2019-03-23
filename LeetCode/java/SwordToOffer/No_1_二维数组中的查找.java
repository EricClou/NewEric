package SwordToOffer;

//在一个二维数组中（每个一维数组的长度相同）
//每一行都按照从左到右递增的顺序排序
//每一列都按照从上到下递增的顺序排序
//请完成一个函数，输入这样的一个二维数组和一个整数
//判断数组中是否含有该整数。


/**
 * 在这样的一个二维数组中，对于左下角的那个元素来讲
 * 以它为起点向右是递增的，向上是递减的
 * 所以比较的方法就是如果target大于它就向右移动
 * 如果target小于它就向上移动
 */
public class No_1_二维数组中的查找 {

    public static void main ( String[] args ) {
        int[][] array = {
                {1, 2}, {3, 4}
        };

        System.out.println(new No_1_二维数组中的查找().Find(2, array));
    }

    public boolean Find ( int target, int[][] array ) {
        //首先第一步要考虑边界条件
        if (array == null) {
            return false;
        }

        //从左下角开始
        int column = 0;
        int row = array.length - 1;

        while (column <= array[0].length - 1 && row >= 0) {
            if (target == array[row][column]) return true;
            if (target > array[row][column]) {
                column++;
            }else {
                row--;
            }
        }
        return false;
    }
}
