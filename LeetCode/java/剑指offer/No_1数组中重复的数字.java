package 剑指offer;

/**
 * 题目：在长度为n的数组中，数组中的每个数字都在0到n-1之间，求有无重复
 * <p>
 * 思路：如果数组是按照顺序排列的，且没有重复，则会有第i个数值（m）在第i个位置。
 * 因此比较第i个数值是否等于位置i，如果等于则向下一步前进。
 * 如果不等于，则对比位置m上的值与第i个数值，如果相等则有重复。
 * 如果不相等则交换彼此位置。
 * 重复此步骤。
 * <p>
 * 分析：整个时间复杂度是O(n)，虽然有两重循环的情况，但是任何位置的数字交换不超过两次都能回到自己的位置。
 * 空间复杂度是O(1)
 */
public class No_1数组中重复的数字 {

    public static void main ( String[] args ) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(checkDuplicate(arr));

    }

    public static boolean checkDuplicate ( int[] numbers ) {
        if (numbers == null) return false;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] > numbers.length - 1) return false;
        }
        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    return true;
                } else swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }


    public static void swap ( int[] numbers, int i, int j ) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
