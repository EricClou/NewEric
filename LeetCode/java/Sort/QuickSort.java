package Sort;

import java.util.Scanner;

public class QuickSort {

    public static void main ( String[] args ) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine().toString();
        String[] arr = a.split(" ");
        int[] tar = new int[arr.length];

        int i;
        for (i = 0; i < tar.length; ++i) {
            tar[i] = Integer.parseInt(arr[i]);
        }

        quickSort(tar, 0, tar.length - 1);

        for (i = 0; i < tar.length; ++i) {
            System.out.print(tar[i] + " ");
        }

    }

    public static void quickSort ( int[] arr, int low, int high ) {
        if (low <= high) {
            int i = low;
            int j = high;

            //拿数组的开头作为标志位
            int temp = arr[low];


            while (i < j) {

                //从右向左找到右边起小的那一个
                while (temp <= arr[j] && i < j) {
                    --j;
                }

                //从左向右起找到左边大的那一个
                while (temp >= arr[i] && i < j) {
                    ++i;
                }


                //两者做交换
                if (i < j) {
                    int t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                }
            }


            //将标志位放好
            arr[low] = arr[i];
            arr[i] = temp;

            //左边继续调用quickSort
            quickSort(arr, low, j - 1);
            //右边继续调用quickSort
            quickSort(arr, j + 1, high);
        }
    }
}
