package Sort;

import java.util.Scanner;

public class BubleSort {
    public static void main ( String[] args ) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().toString();
        String[] arr = str.split(" ");
        int[] a = new int[arr.length];

        int j;
        for (j = 0; j < a.length; ++j) {
            a[j] = Integer.parseInt(arr[j]);
        }

        Bubble(a);

        for (j = 0; j < a.length; ++j) {
            System.out.print(a[j] + " ");
        }

    }

    //标准冒泡排序，时间复杂度为O（n2）
    public static void Bubble ( int[] a ) {

        for (int j = 0; j < a.length - 1; ++j) {
            for (int i = 0; i < a.length - j - 1; ++i) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }

    }

    //进阶冒泡排序，放一个标志位，没有比较则跳出
    public static void Bubble2 ( int[] a ) {
        int count = 0;

        for (int j = 0; j < a.length - 1; ++j) {
            for (int i = 0; i < a.length - j - 1; ++i) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    ++count;
                }

                if (count == 0) {
                    break;
                }
            }
        }

    }


    //继续进阶冒泡排序，除了标志位以外
    public static void Bubble3 ( int[] a ) {
        int count = 0;
        int pos = a.length - 1;

        for (int j = 0; j < a.length - 1; ++j) {
            for (int i = 0; i < pos; ++i) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    ++count;
                }

                pos = i;
                if (count == 0) {
                    break;
                }
            }
        }

    }
}
