package NewCoder.Lesson2;

public class Code05_NetherlandsFlag {

    public static int[] partition ( int[] arr, int l, int r, int p ) {

        //小于区域
        int less = l - 1;

        //大于区域
        int more = r + 1;


        while (l < more) {
            //小于区域前一个数值小于规定数字，则小于区域的最后一个数与其交换，小于区域向右扩张
            if (arr[l] < p) {
                swap(arr, ++less, l++);

                //小于区域前一个数值大于规定数字，则大于区域的最后一个数与其交换，大于区域向左扩张
            } else if (arr[l] > p) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        //返回了规定数字的范围
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
