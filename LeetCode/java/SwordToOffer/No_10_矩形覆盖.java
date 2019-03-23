package SwordToOffer;


//我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
//请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

/**
 * 还是一个斐波那契数列的问题
 */

public class No_10_矩形覆盖 {
    public int RectCover ( int target ) {
        int prePreNumber = 1;
        int preNumber = 2;
        if (target == 1) return 1;
        if (target == 2) return 2;
        int res = 0;
        for (int i = 3; i <= target; i++) {
            res = prePreNumber + preNumber;
            prePreNumber = preNumber;
            preNumber = res;
        }
        return res;

    }
}
