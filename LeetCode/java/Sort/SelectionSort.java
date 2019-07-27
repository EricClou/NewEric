package Sort;

import java.util.Scanner;

//选择排序
public class SelectionSort {
    public static void main ( String[] args ) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine().toString();
        String[] arr = a.split(" ");
        int[] tar = new int[arr.length];

        int j;
        for (j = 0; j < arr.length; ++j) {
            tar[j] = Integer.parseInt(arr[j]);
        }

        Selection(tar);

        for (j = 0; j < arr.length; ++j) {
            System.out.print(tar[j] + " ");
        }

    }


    //选择排序的思想在于挑选出一整个序列当中最小/最大值（索引），然后交换放在合适的位置。
    public static void Selection ( int[] a ) {


        for (int i = 0; i < a.length - 1; ++i) {
            int minIndex = i;

            for (int j = i + 1; j < a.length; ++j) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }

            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }

    }
}