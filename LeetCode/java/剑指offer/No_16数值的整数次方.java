package 剑指offer;

/**
 * 题目：实现函数double Power(double base,int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑库函数问题
 */
public class No_16数值的整数次方 {


    //要考虑到次数可能是0或者负数的情况
    public static double achievePower ( double base, int exponent ) {
        if (base == 0) return 0;
        if (exponent >= 0) {
            double result = 1;
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }
            return result;
        } else {
            double result = 1;
            int count = 0;
            for (int i = exponent; i <= 0; i++) {
                count++;
            }
            for (int i = 0; i < count; i++) {
                result /= base;
            }
            return result;
        }

    }


//    public static double powerWithUnsignegExponent ( double base, int exponent ) {
//        if (exponent == 0) return 1;
//        if (exponent == 1) return base;
//
//        double result = powerWithUnsignegExponent(base,exponent>>1);
//        result*=result;
//        if(exponent&OX1==1)
//    }

}
