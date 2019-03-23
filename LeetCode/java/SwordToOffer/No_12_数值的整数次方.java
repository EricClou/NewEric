package SwordToOffer;

//给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

public class No_12_数值的整数次方 {
    public double Power ( double base, int n ) {
        double res = 1, curr = base;

        int exponent;

        //参数条件特例处理
        if (n > 0) {
            exponent = n;
        } else if (n < 0) {
            if (base == 0)
                throw new RuntimeException("分母不能为0");
            exponent = -n;
        } else {// n==0
            return 1;// 0的0次方
        }


        while (exponent != 0) {
            if ((exponent & 1) == 1) //奇数
                res *= curr;
            curr *= curr;// 翻倍
            exponent >>= 1;// 右移一位
        }
        return n >= 0 ? res : (1 / res);
    }
}
