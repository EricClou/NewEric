package 剑指offer;

/**
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
 * 输出旋转数组的最小元素。例如，数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * <p>
 * 思路：
 * 1、时间复杂度O(n)。由题意可知，这个旋转数组中最小值的特点是，比左边的元素小，比右边的元素大。由于是递增序列，我们只要找到第一个变小的元素就可以了。
 * 2、
 */
public class No_11旋转数组的最小数字 {


    public static void main ( String[] args ) {
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(switchArr2(arr));
    }

    //方法1，时间复杂度是O(n)
    public static int switchArr ( int[] arr ) {

        if (arr == null || arr.length == 0) return 0;

        int length = arr.length;
        for (int i = 1; i < length; i++) {
            if (arr[i - 1] > arr[i]) return arr[i];
        }
        return 0;

    }


    //方法2，二分查找法。因为旋转以后相当于两个有序的数组，这个时间复杂度是O(log N)
    public static int switchArr2 ( int[] arr ) {
        if (arr == null || arr.length == 0) return 0;
        int end = arr.length - 1;
        int start = 0;

        int middle = 0;

        while (end > start) {
            middle = (end - start) / 2 + start;

            if (arr[start] > arr[middle]) {
                end = middle ; //要么在middle上要么在middle的左边
            } else if (arr[start] == arr[middle]) {
                start = middle + 1;
            } else
                //肯定在middle的右边
                start = middle+1;
        }
        return arr[middle];

    }
}
