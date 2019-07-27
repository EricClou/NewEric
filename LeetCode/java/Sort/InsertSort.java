package Sort;

import java.util.Scanner;


//插入排序
public class InsertSort {

    public static void main ( String[] args ) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine().toString();
        String[] res = a.split(" ");
        int[] tar = new int[res.length];

        int i;
        for (i = 0; i < res.length; ++i) {
            tar[i] = Integer.parseInt(res[i]);
        }

        doInsertSort(tar);

        for (i = 0; i < tar.length; ++i) {
            System.out.print(tar[i] + " ");
        }

    }

    public static void doInsertSort ( int[] a ) {
        for (int index = 1; index < a.length; ++index) {
            int temp = a[index];

            int leftindex;
            for (leftindex = index - 1; leftindex >= 0 && a[leftindex] > temp; --leftindex) {
                a[leftindex + 1] = a[leftindex];
            }

            a[leftindex + 1] = temp;
        }

    }
}
