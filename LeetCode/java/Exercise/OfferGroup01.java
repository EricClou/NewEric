package Exercise;


//在其他数字都出现2次的数组里面找到唯一只出现1次的数：[1,2,2,1,3,5,5]

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OfferGroup01 {

    public static void main ( String[] args ) {
        int arr[] = {1, 2, 2, 1, 3, 5, 5};
        System.out.println(new OfferGroup01().findOnce3(arr));
    }

    /**
     * 先排序一遍使用数组计算次数
     * 时间复杂度是nlogn
     *
     * @param arr
     * @return
     */


    public int findOnce ( int[] arr ) {
        Arrays.sort(arr);
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == arr[i + 1]) {
                i += 2;
            } else break;
        }
        return arr[i];

    }


    /**
     * 使用HashMap存储频次
     * 时间复杂度是O(n)
     * 但是如果出现了arr数组过大的情况就会消耗很多的空间
     *
     * @param arr
     * @return
     */
    public int findOnce2 ( int[] arr ) {
        HashMap <Integer, Integer> map = new HashMap();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        return getKey(map, 1);
    }

    private static int getKey ( Map <Integer, Integer> map, int value ) {
        int key = 0;
        for (Map.Entry <Integer, Integer> entry : map.entrySet()) {
            if (value == (entry.getValue())) {
                key = entry.getKey();
            }
        }
        return key;
    }


    /**
     * 运用异或运算，任何一个数字异或它自己都等于0
     * 如果我们从头到尾依次异或数组中的每一个数，那么最终的结果就是那个只出现一次的数字
     * 因为其他出现两次的数字全部在异或中被抵消为0了（异或运算遵循交换分配率）
     *
     * @param arr
     * @return
     */
    public int findOnce3 ( int[] arr ) {
        int resultExclusiveOR = 0;
        for (int i = 0; i < arr.length; ++i)
            resultExclusiveOR ^= arr[i];
        return resultExclusiveOR;

    }


}
