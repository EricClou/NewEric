package NewCoder.Lesson2;


//输入整型数组和排序标识，对其元素按照升序或降序进行排序（一组测试用例可能会有多组数据）
//
//        接口说明
//
//        原型：
//
//

//
//        输入参数：
//
//        Integer[] pIntegerArray：整型数组
//
//        int  iSortFlag：排序标识：0表示按升序，1表示按降序
//
//        输出参数：
//
//        无
//
//        返回值：
//
//        void


//输入描述:
//        1、输入需要输入的整型数个数
//
//
//        输出描述:
//        输出排好序的数字

import java.util.Scanner;

public class 课后练习1 {

    public static void main ( String[] args ) {
        Scanner in = new Scanner(System.in);
//        System.out.printf("输入需要输入的整型数字个数：");

        while (in.hasNext()) {
            int num = in.nextInt();
//        System.out.printf("输入原始数组：");
            Integer[] pIntegerArray = new Integer[num];
            for (int i = 0; i < num; i++) {
                pIntegerArray[i] = in.nextInt();
            }
//        System.out.printf("输入排序方式：");
            int iSortFlag = in.nextInt();
            sortIntegerArray(pIntegerArray, iSortFlag);
            for (int i = 0; i < num; i++) {
                System.out.print(pIntegerArray[i] + " ");
            }
            System.out.print("\n");

        }
    }

    static void sortIntegerArray ( Integer[] pIntegerArray, int iSortFlag ) {
        if (iSortFlag != 0 && iSortFlag != 1) {
            System.out.print("排序方式不正确");
            return;
        }

        if (pIntegerArray == null || pIntegerArray.length == 1) return;

        //升序排列
        if (iSortFlag == 0) {
            for (int i = pIntegerArray.length - 1; i >= 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (pIntegerArray[j] > pIntegerArray[j + 1])
                        swap(pIntegerArray, j, j + 1);
                }
            }
        }


        //降序排列
        if (iSortFlag == 1) {
            for (int i = pIntegerArray.length - 1; i >= 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (pIntegerArray[j] < pIntegerArray[j + 1])
                        swap(pIntegerArray, j, j + 1);
                }
            }
        }


    }

    static void swap ( Integer[] pIntegerArray, int i, int j ) {
        int temp = pIntegerArray[i];
        pIntegerArray[i] = pIntegerArray[j];
        pIntegerArray[j] = temp;
    }
}
