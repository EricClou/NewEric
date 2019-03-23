package Leet;


//给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i]
//的索引 i 的数目来描述。
//返回 A 的任意排列，使其相对于 B 的优势最大化。


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//思路就是把两个数组排序，然后让最小值比最小值
public class No_870_AdvantageShuffle {


    public int[] advantageCount ( int[] A, int[] B ) {
        Arrays.sort(A);
        List <Integer> a = new ArrayList <>();
        for (int a0 : A) {
            a.add(a0);
        }
        int[] res = new int[A.length];
        for (int i = 0, len = B.length; i < len; i++) {
            res[i] = find(a, B[i], 0, a.size() - 1);
        }
        return res;
    }

    //a是由小到大排列的序列
    private int find ( List <Integer> a, int target, int head, int last ) {
        //最大值小于目标值，则最小值肯定小于目标值。此时用这个最小值填充答案序列，剩下较大的去和其他的比较；最小值大于目标值，更应该用这个去填充答案序列。
        if (a.get(last) <= target || a.get(head) > target) {
            int res = a.get(head);
            a.remove(head);
            return res;
        }

        //不符合题目要求，二分
        while (a.get(head) <= target && a.get(last) > target) {

            if (last - head == 1) {
                int res = a.get(last);
                a.remove(last);
                return res;
            }
            int mid = (head + last) / 2;

            if (a.get(mid) <= target) {
                head = mid;
            } else {
                last = mid;
            }
        }
        return 0;
    }
}
