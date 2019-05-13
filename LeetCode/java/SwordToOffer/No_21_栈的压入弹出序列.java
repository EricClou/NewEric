package SwordToOffer;


//输入两个整数序列，第一个序列表示栈的压入顺序，
//请判断第二个序列是否可能为该栈的弹出顺序。
//假设压入栈的所有数字均不相等。
//例如序列 1,2,3,4,5是某栈的压入顺序，
//序列 4,5,3,2,1是该压栈序列对应的一个弹出序列，
//但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）


import java.util.Stack;

public class No_21_栈的压入弹出序列 {

    public static void main ( String[] args ) {
        int[] pushA = new int[]{1, 2, 3, 4, 5};
        int[] popA = new int[]{4, 3, 5, 1, 2};
        System.out.println(new No_21_栈的压入弹出序列().IsPopOrder(pushA, popA));


    }

    public boolean IsPopOrder ( int[] pushA, int[] popA ) {

        int[] result = new int[pushA.length];
        Stack <Integer> help = new Stack <>();
        int pB = 0;
        int index = 0;
        for (int i = 0; i <= pushA.length - 1; i++) {
            help.push(pushA[i]);
            if (help.peek() == popA[pB]) {
                result[index++] = help.pop();
                pB++;

            }
        }
        while (!help.isEmpty()) {
            result[index++] = help.pop();
        }

        for (int i = 0; i <= pushA.length - 1; i++) {
            if (result[i] != popA[i])
                return false;
        }

        return true;


    }
}
