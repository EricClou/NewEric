package 剑指offer;

/**
 * 题目：地上有一个m行n列的方格。一个机器人从坐标（0，0）的格子开始移动，它每次
 * 可以左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35，37），因为3+5+3+7=18。但它不能进入
 * 方格（35，38），因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 思路：一般在二维方格问题上注意使用回溯法，无论是有无路线可走或者是格子数计算的等等问题
 */
public class No_13机器人的运动范围 {

    public static int movingCount ( int k, int rows, int cols ) {
        if (k < 0 || rows < 0 || cols < 0) return 0;
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < rows * cols; i++) visited[i] = false;


        int count = movingCountCore(k, rows, cols, 0, 0, visited);
        return count;


    }


    //当前点是否可以移动
    public static int movingCountCore ( int k, int rows, int cols, int row, int col, boolean[] visited ) {
        int count = 0;


        //如果可以走则
        if (check(k, rows, cols, row, col, visited)) {

            //可以走，这个visited的作用就是在check的时候保证这个点之前没有走过
            visited[row * cols + col] = true;

            count = 1 + movingCountCore(k, rows, cols, row - 1, col, visited) +
                    movingCountCore(k, rows, cols, row, col - 1, visited) +
                    movingCountCore(k, rows, cols, row + 1, col, visited) +
                    movingCountCore(k, rows, cols, row, col + 1, visited);
        }
        return count;


    }


    //当前位置能走
    public static boolean check ( int k, int rows, int cols, int row, int col, boolean[] visited ) {

        if (row >= 0 && row < rows && col >= 0 && col < cols && getDigitSum(row) + getDigitSum(col) <= k
                && !visited[row * cols + col]) return true;
        return false;

    }

    static int getDigitSum ( int number ) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
