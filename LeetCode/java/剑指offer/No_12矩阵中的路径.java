package 剑指offer;

/**
 * 题目：请设计一个函数，用来判断一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵的任意一格
 * 开始，每一步可以在矩阵向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该
 * 格子。
 * <p>
 * 思路：
 * <p>
 * 这是一个可以用回朔法解决的典型题。首先，在矩阵中任选一个格子作为路径的起点。如果路径上的第i个字符不是ch，那么这个格子不可能处在路径上的
 * 第i个位置。如果路径上的第i个字符正好是ch，那么往相邻的格子寻找路径上的第i+1个字符。除在矩阵边界上的格子之外，其他格子都有4个相邻的格子。
 * 重复这个过程直到路径上的所有字符都在矩阵中找到相应的位置。
 * 由于回朔法的递归特性，路径可以被开成一个栈。当在矩阵中定位了路径中前n个字符的位置之后，在与第n个字符对应的格子的周围都没有找到第n+1个
 * 字符，这个时候只要在路径上回到第n-1个字符，重新定位第n个字符。
 * 由于路径不能重复进入矩阵的格子，还需要定义和字符矩阵大小一样的布尔值矩阵，用来标识路径是否已经进入每个格子。 当矩阵中坐标为（row,col）的
 * 格子和路径字符串中相应的字符一样时，从4个相邻的格子(row,col-1),(row-1,col),(row,col+1)以及(row+1,col)中去定位路径字符串中下一个字符
 * 如果4个相邻的格子都没有匹配字符串中下一个的字符，表明当前路径字符串中字符在矩阵中的定位不正确，我们需要回到前一个，然后重新定位。
 * 一直重复这个过程，直到路径字符串上所有字符都在矩阵中找到合适的位置
 */


//用回溯法解决问题
public class No_12矩阵中的路径 {


    public static void main ( String[] args ) {

    }

    /**
     * @param matrix 矩阵
     * @param rows   矩阵的行
     * @param cols   矩阵的列
     * @param str    某字符串
     * @return
     */
    public static boolean hasPath ( char[] matrix, int rows, int cols, char[] str ) {

        //矩阵为空
        if (matrix == null || rows < 1 || cols < 1 || str == null) return false;


        //对应矩阵创建布尔数组，用于判断矩阵当前的元素是否已经经过
        boolean[] visited = new boolean[rows * cols];


        //通过i与j遍历找出矩阵中对应位置的元素是否访问完
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                //这里全部访问完才会显示true
                if (hasPathCore(matrix, rows, cols, i, j, str, 0, visited))
                    return true;
            }
        }
        return false;

    }


    public static boolean hasPathCore ( char[] matrix, int rows, int cols, int row, int col, char[] str, int k, boolean[] visited ) {
        //使用这种方法用二维代表一维
        int index = row * cols + col;

        //输入行/列超过范围，矩阵中的元素与字符串上的对不上，已经访问过
        //以上三个理由则返回false
        if (row < 0 || row >= rows || col < 0 || col >= cols || matrix[index] != str[k] || visited[index] == true)
            return false;

        //全部找完
        if (k == str.length - 1) return true;

        //假设位置已经访问完毕
        visited[index] = true;

        //上下左右选择查找，当有一个位置查到了str的结尾，返回true则终止循环
        if (hasPathCore(matrix, rows, cols, row - 1, col, str, k + 1, visited)
                || hasPathCore(matrix, rows, cols, row + 1, col, str, k + 1, visited)
                || hasPathCore(matrix, rows, cols, row, col - 1, str, k + 1, visited)
                || hasPathCore(matrix, rows, cols, row, col + 1, str, k + 1, visited)) {
            return true;
        }
        //没有找到，复原原来并没有访问的状态
        visited[index] = false;
        return false;

    }
}
