package basic_class_0102;


//问题二(荷兰国旗问题)
//        给定一个数组arr，和一个数num，请把小于num的数放在数组的左边
//        等于num的数放在数组的中间，大于num的数放在数组的右边。
public class Code_08_NetherlandsFlag {


    //这个荷兰国旗问题就相当于有一组数，而在数组的最左边是小于区域，最右边是大于区域，两边是慢慢向内扩张的感觉
    public static int[] partition ( int[] arr, int l, int r, int p ) {
        int less = l - 1;
        int more = r + 1;
        while (l < more) {
            if (arr[l] < p) {
                //这里less是-1而l是0，如果遇到数组的第一个数字与给定的数字小，那么相当于是自己与自己交换
                swap(arr, ++less, l++);
            } else if (arr[l] > p) {
                //如果数组元素大于给定数字，那么把当前数组元素与大于区域的左边界交换。
                swap(arr, --more, l);
            } else {
                l++;
            }
        }

        //等于区域的左边界和右边界
        return new int[]{less + 1, more - 1};
    }

    // for test
    public static void swap ( int[] arr, int i, int j ) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static int[] generateArray () {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
        }
        return arr;
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

    public static void main ( String[] args ) {
        int[] test = generateArray();

        printArray(test);
        int[] res = partition(test, 0, test.length - 1, 1);
        printArray(test);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }
}
