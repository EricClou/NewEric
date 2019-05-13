package SwordToOffer;

import java.util.Arrays;
import java.util.Stack;


// 定义栈的数据结构，
// 请在该类型中实现一个能够得到栈中所含最小元素的min函数
// （时间复杂度应为O（1））。


/**
 * 当想创造一个栈的先进后出结构时候，最简单的还是使用数组，方便把握长度。
 * 在这种情况下我们可以使用Integer数组，专门写个扩容函数防止空间不够用
 */
public class No_20_包含min函数的栈 {

    private int size;
    private int min = Integer.MAX_VALUE;

    //创建一个辅助栈，专门存储最小值
    private Stack <Integer> minStack = new Stack <Integer>();
    private Integer[] elements = new Integer[10];

    public void push ( int node ) {
        ensureCapacity(size + 1);
        elements[size++] = node;
        if (node <= min) {
            minStack.push(node);
            min = node;
        } else {
            minStack.push(min);
        }
    }


    //确保空间足够
    private void ensureCapacity ( int size ) {
        int len = elements.length;
        if (size > len) {
            int newLen = (len * 3) / 2 + 1; //每次扩容方式
            elements = Arrays.copyOf(elements, newLen);
        }
    }

    public void pop () {
        Integer top = top();
        if (top != null) {
            elements[size - 1] = (Integer) null;
        }
        size--;
        minStack.pop();
        min = minStack.peek();
        //    System.out.println(min+"");
    }

    public int top () {
        if (!empty()) {
            if (size - 1 >= 0)
                return elements[size - 1];
        }
        return (Integer) null;
    }

    public boolean empty () {
        return size == 0;
    }

    public int min () {
        return min;
    }
}
