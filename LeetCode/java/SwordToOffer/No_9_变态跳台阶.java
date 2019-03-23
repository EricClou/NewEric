package SwordToOffer;


//一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
//求该青蛙跳上一个n级的台阶总共有多少种跳法。

/**
 * 这种题目最好实际列出序列然后找规律
 * 这样做比较方便
 * <p>
 * 列出序列以后发现后面每一个都是前面的2倍关系
 */
public class No_9_变态跳台阶 {
    public int JumpFloorII ( int target ) {
        if (target == 1) return 1;
        return JumpFloorII(target - 1) * 2;
    }


    /**
     * 终极数学推理大法
     * @param target
     * @return
     */
    public int JumpFloor3 ( int target ) {

        return (int)Math.pow(2,target-1);
    }
}
