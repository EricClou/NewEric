package SwordToOffer;


//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
//例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
//则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.


import java.util.ArrayList;


/**
 * 变成一个剥圈函数
 */
public class No_19_顺时针打印矩阵 {
    ArrayList a = new ArrayList();

    public ArrayList printMatrix ( int[][] matrix ) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {//左上边界最多到达右下边界，用于判断是否是剥圈打印
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
        return a;
    }

    public void printEdge ( int[][] m, int tR, int tC, int dR, int dC ) {
        if (tR == dR) {  //先判断是否只是一横行 如果是 打印该横行的列（通常用于内圈）
            for (int i = tC; i <= dC; i++) {
                a.add(m[tR][i]);
            }
        } else if (tC == dC) {//再判断是否只是一竖列 如果是 打印该横行的列（通常用于内圈
            for (int i = tR; i <= dR; i++) {
                a.add(m[i][tC]);
            }
        } else {
            int curC = tC; //用2个变量储存 用于判断当前位置
            int curR = tR;
            while (curC != dC) {  // 当前位置未到达当前行的最右列 --》往右去
                a.add(m[tR][curC]);
                curC++;
            }
            while (curR != dR) {  // 当前位置未到达当前列的最底行 --》往下去
                a.add(m[curR][dC]);
                curR++;
            }
            while (curC != tC) {  // 当前位置未到达当前行的最左列 --》往左去
                a.add(m[dR][curC]);
                curC--;
            }
            while (curR != tR) {  //当前位置未到达当前列的最顶行 --》往上去
                a.add(m[curR][tC]);
                curR--;
            }
        }
    }
}