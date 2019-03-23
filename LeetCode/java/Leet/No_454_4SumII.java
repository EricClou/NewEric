package Leet;

import java.util.HashMap;
import java.util.Map;

public class No_454_4SumII {
    public int fourSumCount ( int[] A, int[] B, int[] C, int[] D ) {
        // 用于记录AB两个数组的和, Key为A中元素和B中元素和, Value为这个和出现的次数
        Map <Integer, Integer> mapAB = new HashMap <>();
        int length = A.length;
        int sum;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                sum = A[i] + B[j];
                //getOrDefault是当map内含有这个key的时候就调用这个值，如果没有这个key就调用第二个参数defaultValue
                mapAB.put(sum, mapAB.getOrDefault(sum, 0) + 1);
            }
        }

        int result = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                sum = C[i] + D[j];
                if (mapAB.containsKey(-sum)) {
                    //有几种出现次数就有几种0和情况
                    result += mapAB.get(-sum);
                }
            }
        }

        return result;
    }

}