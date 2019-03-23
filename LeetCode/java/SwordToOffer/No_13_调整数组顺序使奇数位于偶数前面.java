package SwordToOffer;


//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
//所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数a之间的相对位置不变。
public class No_13_调整数组顺序使奇数位于偶数前面 {

    public static void main ( String[] args ) {
        int[] array = {-1, -2, 3, -4, 5, -6, 7, 8};
        new No_13_调整数组顺序使奇数位于偶数前面().reOrderArray2(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 这个算法额外开辟了储存空间，属于用空间换取时间的方式
     * 一旦面试的时候要求不能创建出新数组，这个方法就失效了
     * <p>
     * tips：采用两个整型变量一个存储奇数个数，一个存储偶数在数组中的起始序号
     *
     * @param array
     */
    public void reOrderArray ( int[] array ) {
        int oddCount = 0;
        int oddBegin = 0;
        int[] res = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) oddCount++;
        }

        for (int i = 0; i < array.length; i++) {
            //如果是奇数，从头开始存
            //如果是偶数，从奇数个数后面一个位置开始存
            if ((array[i] & 1) == 1) res[oddBegin++] = array[i];
            else res[oddCount++] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = res[i];
        }
    }


    //试试看双指针法

    /**
     * i从左向右遍历，找到第一个偶数
     * j从j+1开始向右遍历，直到找到第一个奇数
     * 找到后将[i,...,j-1]的元素整体向后移一位，最后将找到的奇数放入i位置，然后i++;
     * 终止条件：j向后遍历查找失败。没有找到奇数，所以偶数全在后面了，排序完成
     * @param a
     *
     *
     * 这种做法时间复杂度是n2，但是节省了空间复杂度
     */

    public void reOrderArray2 ( int[] a ) {
        if (a == null || a.length == 0)
            return;
        int i = 0, j;
        while (i < a.length) {
            while (i < a.length && !isEven(a[i]))
                i++;
            j = i + 1;
            while (j < a.length && isEven(a[j]))
                j++;
            if (j < a.length) {
                int tmp = a[j];
                //移动
                for (int j2 = j - 1; j2 >= i; j2--) {
                    a[j2 + 1] = a[j2];
                }
                a[i++] = tmp;
            } else {// 没有找到奇数，所以偶数全在后面了，排序完成
                break;
            }
        }
    }

    boolean isEven ( int n ) {
        if ((n & 1) == 0)
            return true;
        return false;
    }


}