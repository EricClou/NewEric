package 剑指offer;


/**
 * 题目：输入一个整数数组，实现一个函数来调整该数组中的数字的顺序。
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组后半部分。
 */
public class No_22调整数组顺序使奇数位于偶数前面 {


    public static void changeOddFirst ( int[] arr ) {

        if (arr == null) return;

        //记录奇数的位置
        int[] odd = new int[arr.length];
        int oddIndex = 0;

        int[] even = new int[arr.length];
        int evenIndex = 0;


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                odd[oddIndex++] = arr[i];
            } else even[evenIndex++] = arr[i];
        }

        for (int i = 0; i < oddIndex; i++) {
            arr[i] = odd[i];
        }
        for (int i = 0; i < evenIndex; i++) {
            arr[oddIndex++] = even[i];
        }
    }


        public void reOrderArray ( int[] array){
            if (array.length == 0 || array.length == 1) return;
            int oddCount = 0, oddBegin = 0;
            int[] newArray = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                if ((array[i] & 1) == 1) oddCount++;
            }
            for (int i = 0; i < array.length; i++) {
                if ((array[i] & 1) == 1) newArray[oddBegin++] = array[i];
                else newArray[oddCount++] = array[i];
            }
            for (int i = 0; i < array.length; i++) {
                array[i] = newArray[i];
            }
        }
    }
