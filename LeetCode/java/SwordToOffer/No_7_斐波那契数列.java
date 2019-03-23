package SwordToOffer;

//
//大家都知道斐波那契数列，
//现在要求输入一个整数n
//请你输出斐波那契数列的第n项
//（从0开始，第0项为0），n<=39

public class No_7_斐波那契数列 {

    public static void main ( String[] args ) {
        System.out.println(new No_7_斐波那契数列().Fibonacci(3));
    }

    public int Fibonacci ( int n ) {
        if (n == 0) return 0;
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        int index = 2;
        while (index <= n) {
            res[index] = res[index - 1] + res[index - 2];
            index++;
        }
        return res[--index];

    }


    /**递归的写法
     * 乍一看很简单，但是运行起来很消耗时间和空间
     * 在n比较大的情况下很容易不能通过
     * @param n
     * @return
     */

        public int Fibonacci1(int n) {
            if(n==0){
                return 0;
            }
            if(n==1){
                return 1;
            }
            int f=0;
            if(n>1&&n<=39){
                f=Fibonacci(n-1)+Fibonacci(n-2);
            }
            return f;
        }


    /**
     * 这个是最佳算法，时间复杂度是O(n)，空间复杂度是O(1)，相较于我写的方法空间复杂度更优
     * @param n
     * @return
     */
    public int Fibonacci2(int n) {
        int preNum=1;
        int prePreNum=0;
        int result=0;
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        for(int i=2;i<=n;i++){
            result=preNum+prePreNum;
            prePreNum=preNum;
            preNum=result;
        }
        return result;

    }


}
