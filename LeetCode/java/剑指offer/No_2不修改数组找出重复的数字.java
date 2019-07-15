package 剑指offer;

/**
 * 题目要求：在一个长度为n+1的数组里的所有数字都在1-n的范围内，所以数组中至少有一个数字是重复的。
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组。
 * <p>
 * 思路：相对于上一题目，我们的新要求在于不能修改数组。
 * 简单方法：创建一个新数组，把原数组中值为m的数字复制到新数组中的m位置。很容易找到重复的值。
 * 但是这种方法需要创建新的数组，需要O(n)的辅助空间。
 * 实际方法：我们可以使用二分法的思维。把从1-n的数字从中间的数字m分为两个部分，前面一半为1～m，
 * 后面一半为m+1～n。如果1～m的数字的出现次数超过m，那么这一半的区间里一定包含重复数字；
 * 否则，另一半m+1~n的区间里一定包含重复数字。然后可以进一步将包含重复数字的区间一分为二，直到找到重复数字。
 *
 * 分析：这个时间复杂度是O(nlogn)，空间复杂度是O(1)。相对于简单方法的时间复杂度O(n)，空间复杂度O(n)来说这是一种时间换空间的方法
 */

public class No_2不修改数组找出重复的数字 {
    public static void main ( String[] args ) {
        int[] arr = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(getDuplication(arr));
    }

    public static int getDuplication ( int[] numbers ) {
        if (numbers == null) return -1;

        int start = 1;
        int end = numbers.length - 1;
        while (end >= start) {

            int middle = ((end - start) >> 1) + start;

            //这个会被调用log(n)次
            int count = countRange(numbers, start, middle);

            //划分到最后单个的部分
            if (end == start) {
                if (count > 1) return start;
                else break;
            }

            //如果重复的范围在前半部分
            if (count > (middle - start + 1)) end = middle;
                //如果重复的范围在后半部分
            else start = middle + 1;
        }
        return -1;
    }


    //计算出现次数，若大于范围则必有重复数字,当start与end相同的时候就相当于在找这个单独数字在数组中的出现次数
    public static int countRange ( int[] numbers, int start, int end ) {
        if (numbers == null) return 0;

        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= start && numbers[i] <= end)
                ++count;
        }
        return count;

    }
}
