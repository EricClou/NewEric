package NewCoder.Lesson2;


//对于一个无序数组A，请设计一个算法，求出需要排序的最短子数组的长度。
//给定一个整数数组A及它的大小n，请返回最短子数组的长度。

import java.util.Arrays;

//测试样例：
//        [1,5,3,4,2,6,7],7
//        返回：4
public class 课后练习3 {


    public static void main ( String[] args ) {
        int A[] = {1, 2, 3, 3, 8, 9};
        int n = 6;
        System.out.println(findShortest(A, n));

    }

    public static int findShortest ( int[] A, int n ) {
        int[] origin = new int[n];
        for (int i = 0; i < n; i++) origin[i] = A[i];
        Arrays.sort(A);

        int left = 0;
        int right = n - 1;

        while (right >= left) {
            if (origin[left] == A[left]) {
                left++;
            } else break;
            if (right == left) return 0;
        }
        int ansL = left;

        left = 0;
        right = n - 1;
        while (right >= left) {
            if (origin[right] == A[right]) {
                right--;
            } else break;
        }

        int ansR = right;

        return ansR - ansL + 1;
    }
}
