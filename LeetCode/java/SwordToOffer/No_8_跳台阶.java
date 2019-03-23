package SwordToOffer;


//一只青蛙一次可以跳上1级台阶，也可以跳上2级。
//求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

public class No_8_跳台阶 {
    public int JumpFloor ( int target ) {
        int preNum = 2;
        int prePreNum = 1;
        int result = 0;
        if (target == 2)
            return 2;
        if (target == 1)
            return 1;
        for (int i = 3; i <= target; i++) {
            result = preNum + prePreNum;
            prePreNum = preNum;
            preNum = result;
        }
        return result;

    }
}
