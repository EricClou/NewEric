package basic_class_0102;

import java.util.Arrays;
//1、让数组成为大根堆
//2、把最后一个位置与堆顶位置做交换
//3、堆顶位置换下来顶元素弹出，这个就是最大值（所谓的弹出就是在进行新的堆顶元素调整的时候把堆的范围减少一个
//4、对新的堆顶元素进行调整，得到新的堆顶
//5、重复执行2-4步，不断地弹出，得到一个从小到大的顺序数组


//推排序的平均复杂度是nlogn
//堆排序是不稳定的排序
public class Code_03_HeapSort {

    public static void heapSort ( int[] arr ) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    public static void heapInsert ( int[] arr, int index ) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify ( int[] arr, int index, int size ) {
        int left = index * 2 + 1;
        //先要判断子节点是否越界
        while (left < size) {
            //右孩子是否越界且把左孩子与右孩子比较大的那一个赋给largest
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            //子节点中较大的那个与父节点相比哪个大
            largest = arr[largest] > arr[index] ? largest : index;
            //如果是父节点大那么没必要调整了
            if (largest == index) {
                break;
            }
            //否则交换位置
            swap(arr, largest, index);
            //指向交换后大新位置
            index = largest;
            //找到新的子节点，循环下一步
            left = index * 2 + 1;
        }
    }

    public static void swap ( int[] arr, int i, int j ) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

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
            heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }

}
