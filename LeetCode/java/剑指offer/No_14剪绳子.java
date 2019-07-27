package 剑指offer;


/**
 * 题目：给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1且m>1），每段绳子的长度
 * 记为k[0],k[1],...,k[m]。请问其乘积的最大值可能是多少？例如，当绳子的长度是8时，我们把
 * 它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 思路：
 * 1、动态规划方法：
 * 动态规划的特点：
 * 1）把大问题分解成小问题，分解后的每个小问题也存在最优解
 * 2）小问题的最优解组合起来能够得到整个问题的最优解
 * 3）把大问题分解为若干个小问题，这些小问题之间还有互相重叠的更小的子问题
 * 4）从上往下分析问题，从下往上求解问题
 * <p>
 * 2、贪婪算法：
 * 每一步的选择尽可能地选择大的那个
 */
public class No_14剪绳子 {


    //动态规划
    public static int maxProductAfterCutting_solution1 ( int length ) {


        //这里就划分到了最小到子问题，如果绳子长度为1或者0。那么乘积结果为0
        //如果绳子长度为1，那么乘积结果为1
        //如果绳子长度为3，那么乘积结果为2
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;

        //把子问题到最优解存储在数组里面，数组中第i个元素代表把长度为i的绳子剪成若干段之后各段长度乘积的最大值
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max = 0;

        //i循环递增代表计算顺序自下而上
        for (int i = 4; i <= length; ++i) {
            max = 0;

            //在求f(i)之前，对于每个j而言（0<j<i）,f(j)都已经求出来了
            //为了求解f(i)，我们要求出所有可能的f(i)*f(i-j)并比较出它们的最大值
            //这里取 j <= i / 2 是因为一旦超过这个，就有参数是重复的了
            for (int j = 1; j <= i / 2; ++j) {
                int product = products[j] * products[i - j];
                if (max < product) max = product;

                products[i] = max;
            }
        }
        max = products[length];

        return max;
    }


    //贪婪算法
    public static int maxProductAfterCutting_solution2 ( int length ) {

        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;

        //尽可能多地剪去长度为3的绳子短
        int timesOf3 = length / 3;

        //当绳子最后剩下长度为4的时候，不能再剪去长度为3的绳子段
        //此时更好的方法是把绳子剪成长度为2的两段
        if(length-3*timesOf3==1) timesOf3-=1;
        int timesOf2=(length-3*timesOf3)/2;
        return (int)(Math.pow(3,timesOf3))*(int)(Math.pow(2,timesOf2));

    }
}
