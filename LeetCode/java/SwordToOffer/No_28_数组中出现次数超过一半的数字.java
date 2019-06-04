package SwordToOffer;

//数组中有一个数字出现的次数超过数组长度的一半，
//请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
//由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

public class No_28_数组中出现次数超过一半的数字 {


    public int MoreThanHalfNum_Solution ( int[] array ) {
        int length = array.length;
        if (length == 0) return 0;
        int[] help = new int[1000];
        for (int i = 0; i < length; i++) {
            help[array[i]]+=1;
        }
        for (int i = 0; i < 1000; i++) {
            if (help[i] > length / 2) return i;
        }
        return 0;
    }
}
