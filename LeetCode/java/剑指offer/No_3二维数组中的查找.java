package 剑指offer;

/**
 * 题目描述：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 思路：如果做逐行逐个比较，那么时间复杂度是O(n2)。假设输入的整数是m。我们可以从整个二维数组的左下角出发。
 * 若m小于此值，向上走。如果m大于此值，向右走。这个时间复杂度是O(n)。
 */
public class No_3二维数组中的查找 {

    public static void main ( String[] args ) {
        int arr[][]={{1,2,3,4,5},{6,7,8,9,10}};
        System.out.println(findInArray(arr,0));
    }

    public static boolean findInArray ( int[][] arr, int m ) {
        if (arr == null) return false;
        int row = arr.length;
        int col = arr[0].length;

        int row_index = row - 1;
        int col_index = 0;
        while (row_index >= 0 && col_index <= col - 1) {
            if (m > arr[row_index][col_index]) {
                col_index++;
            } else if (m < arr[row_index][col_index]) {
                row_index--;
            } else
                return true;
        }
        return false;

    }
}
