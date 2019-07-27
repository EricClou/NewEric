package Sort;

import java.util.Scanner;

public class MergeSort {

    public static void main ( String[] args ) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine().toString();
        String[] arr = a.split(" ");
        int[] tar = new int[arr.length];

        int i;
        for (i = 0; i < arr.length; ++i) {
            tar[i] = Integer.parseInt(arr[i]);
        }

        sort(tar, 0, tar.length - 1);

        for (i = 0; i < tar.length; ++i) {
            System.out.print(tar[i] + " ");
        }

    }

    public static void sort ( int[] a, int low, int high ) {
        int mid = (low + high) / 2;
        if (low < high) {
            sort(a, low, mid);
            sort(a, mid + 1, high);
            merge(a, low, mid, high);
        }

    }

    public static void merge ( int[] a, int low, int mid, int high ) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int var7 = 0;

        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[var7++] = a[i++];
            } else {
                temp[var7++] = a[j++];
            }
        }

        while (i <= mid) {
            temp[var7++] = a[i++];
        }

        while (j <= high) {
            temp[var7++] = a[j++];
        }

        for (int x = 0; x < temp.length; ++x) {
            a[x + low] = temp[x];
        }

    }
}
