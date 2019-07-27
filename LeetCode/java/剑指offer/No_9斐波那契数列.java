package 剑指offer;

/**
 * 题目：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
 */
public class No_9斐波那契数列 {

    public static void main ( String[] args ) {
        System.out.println(fibonacci2(3));
    }


    //递归方法求解斐波那契数列
    public static int fibonacci1 ( int n ) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    //用循环方法求解斐波那契数列，时间复杂度是O(n)
    public static int fibonacci2 ( int n ) {
        int a = 0;
        int b = 1;
        int c = a + b;
        if (n == 0) return a;
        if (n == 1) return b;
        if (n == 2) return c;

        while (n > 2) {
            a = b;
            b = c;
            c = a + b;
            n--;
        }
        return c;
    }


}
