package basic_class_0102;

import java.util.Arrays;

//冒泡排序，冒泡排序是指两个相邻的元素互相比较，像泡泡一样往上浮
//每一次循环一个最大的元素上浮到最右边，经过n次循环之后就完成了排序
//冒泡排序的平均时间负责度是n^2


//优化冒泡排序的方法之一是可以设置一个boolean比较位
//在一层循环上如果都没有发生比较说明已经完成了比较，此时就可以跳出循环了
//冒泡排序是稳定的排序

public class Code_00_BubbleSort {

    public static void bubbleSort ( int[] arr ) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    //有异或方法交换两个数据，不用额外引用变量，但是这种方法只是耍小聪明，看起来少引入变量提高了效率
    //但是实际上异或方法增加了6个操作数，3次计算，实际耗时大于交换，且也不利于代码阅读
    public static void swapOrNot ( int[] arr, int i, int j ) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void swap ( int[] arr, int i, int j ) {
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }




    //对数器


    // for test
    public static void comparator ( int[] arr ) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray ( int maxSize, int maxValue ) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray ( int[] arr ) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual ( int[] arr1, int[] arr2 ) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray ( int[] arr ) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main ( String[] args ) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            bubbleSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }

}
